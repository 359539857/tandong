package cto.framework.service;

import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.core.util.StringHelper;
import cto.framework.core.util.Utility;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.helper.ServiceBusHelper;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.schema.ServiceBusConfig;
import cto.framework.service.task.DynamicListenerConfigTask;
import cto.framework.service.task.TaskExecutor;

public class ServiceBus implements IServiceBus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8970106024262601371L;

	private static Logger logger = Logger.getLogger(ServiceBus.class);

	private static IServiceBus serviceBus;
	private ServiceBusConfig serviceBusConfig;
	private IServiceEngine serviceEngine;
	private CacheManager cacheManager;

	private Map<String, String> propertyMap;
	private Map<String, String> globalParameterMap;
	private Map<String, Map<String, String>> serviceParameterMap;
	private Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap;
	private Map<String, Service> serviceMap;
	private CTO servicePathCTO;
	private Map<String, Trans> transMap;
	private CTO ctoHadoopGroup;
	private IDataEngine singeDataEngine;
	private IDataEngine writeDataEngine;
	private IDataEngine readDataEngine;

	private ServiceBus() {
		propertyMap = new HashMap<String, String>();
		globalParameterMap = new HashMap<String, String>();
		serviceParameterMap = new HashMap<String, Map<String, String>>();
		dataSourceGroupMap = new HashMap<String, CycleMap<String, IDataEngine>>();
		serviceMap = new HashMap<String, Service>();
		servicePathCTO = new CTO();
		transMap = new HashMap<String, Trans>();
		ctoHadoopGroup = new CTO();
		serviceEngine = new ServiceEngine();
		cacheManager = CacheManager.getInstance();
	}

	public static IServiceBus getInstance() {
		if (serviceBus == null) {
			serviceBus = new ServiceBus();
		}
		return serviceBus;
	}

	public void init(String serviceBusConfigPath) throws Exception {
		if (StringHelper.isBlank(serviceBusConfigPath)) {
			serviceBusConfigPath = Constant.DEFAULT_SERVICE_FRAMEWORK_CONFIG;
		}
		String serviceBusConfigXml = null;
		if (serviceBusConfigPath.startsWith("classpath:")) {
			int index = serviceBusConfigPath.indexOf(":");
			serviceBusConfigPath = serviceBusConfigPath.substring(index + 1, serviceBusConfigPath.length());
			URL url = Thread.currentThread().getContextClassLoader().getResource("");
			serviceBusConfigPath = url.getPath() + serviceBusConfigPath;
		}
		serviceBusConfigXml = Utility.readTextFile(serviceBusConfigPath, "UTF-8");

		if (!StringHelper.isNotBlank(serviceBusConfigXml)) {
			throw new RuntimeException("没有找到 " + serviceBusConfigPath);
		}
		serviceBusConfig = ServiceBusHelper.fromFramworkXML(serviceBusConfigXml);
		// servicePathCTO.setStringValue("ActionFramework",
		// serviceBusConfigPath);
		// 初始化全局参数
		ServiceBusHelper.initImportSource(serviceBusConfig, propertyMap);
		ServiceBusHelper.initGlobalParameter(serviceBusConfig, globalParameterMap, propertyMap);
		ServiceBusHelper.initDataSource(this, serviceBusConfig, dataSourceGroupMap, propertyMap);
		ServiceBusHelper.initCacheContainer(cacheManager, serviceBusConfig, propertyMap);
		ServiceBusHelper.initHadoopGroupServer(serviceBusConfig, ctoHadoopGroup, propertyMap);
		ServiceBusHelper.initServicePlugin(serviceBusConfig, serviceMap, transMap, serviceParameterMap, propertyMap, servicePathCTO);
		long serviceListenerIntervalTime = serviceBusConfig.getServiceListenerIntervalTime();
		TaskExecutor.getInstance().executeTask(new DynamicListenerConfigTask(this, servicePathCTO, serviceMap, transMap, serviceParameterMap, propertyMap, serviceListenerIntervalTime));
		System.out.println(servicePathCTO);
		if (logger.isInfoEnabled()) {
			logger.info("ctoframework start successfully......");
		}
	}

	public void start(String applicationConfigPath) throws Exception {
		this.init(applicationConfigPath);
	}

	public void stop() throws Exception {
		if (cacheManager != null) {
			this.cacheManager.close();
		}
	}

	public Return execute(CTORequest ctoRequest, CTOResponse ctoResponse) {
		Return $return = validator(ctoRequest);
		if (Return.executeSuccess($return)) {
			Return $preReturn = beforeExecute(ctoRequest, ctoResponse);
			if (Return.executeSuccess($preReturn)) {
				String serviceName = ctoRequest.getStringValue(Constant.STR_SERVICE_NAME);
				Map<String, String> $serviceParameterMap = this.serviceParameterMap.get(serviceName);
				this.addServiceAndGlobalParameterToCTORequest(ctoRequest, $serviceParameterMap);// 把全局参数和服务参数添加至CTORequest
				serviceEngine.setDataSourceGroupMap(dataSourceGroupMap);
				serviceEngine.setServiceMap(serviceMap);
				serviceEngine.setTransMap(transMap);
				serviceEngine.setPropertyMap(propertyMap);
				serviceEngine.setServiceBus(this);
				serviceEngine.setCacheManager(cacheManager);
				Service service = serviceMap.get(serviceName);
				if(StringHelper.isNotBlank(service.getCacheGroupId())){
					ctoRequest.setStringValue(Constant.CACHEGROUP, service.getCacheGroupId());
				}
				try {
					Return $processReturn = serviceEngine.processAction(ctoRequest, ctoResponse);
					if (Return.executeSuccess($processReturn)) {
						afterExecute(ctoRequest, ctoResponse);
					}
					return $processReturn;
				} catch (Exception ex) {
					try {
						exceptionExecute(ctoRequest, ctoResponse);
					} catch (Exception e) {
						logger.error(ExceptionUtils.getFullStackTrace(ex));
						return Return.valueOf("-1", ExceptionUtils.getFullStackTrace(ex));
					}
					logger.error(ExceptionUtils.getFullStackTrace(ex));
					return Return.valueOf("-1", ExceptionUtils.getFullStackTrace(ex));
				}
			} else {
				return $preReturn;
			}
		} else {
			return $return;
		}
	}

	private void addServiceAndGlobalParameterToCTORequest(CTORequest ctoRequest, Map<String, String> $serviceParameterMap) {
		Iterator<String> iterator = $serviceParameterMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = $serviceParameterMap.get(key);
			ctoRequest.setObjectValue(key, value);
		}
		Iterator<String> iterator2 = globalParameterMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator2.next();
			Object value = $serviceParameterMap.get(key);
			ctoRequest.setObjectValue(key, value);
		}
	}

	public Return validator(CTORequest ctoRequest) {
		if (ctoRequest == null) {
			return Return.valueOfFail("ctoRequest is null");
		}
		if (!ctoRequest.exists(Constant.STR_SERVICE_NAME)) {
			return Return.valueOfFail("ctoRequest serviceName does not exist");
		}
		if (!ctoRequest.exists(Constant.STR_TRANS_NAME)) {
			return Return.valueOfFail("ctoRequest transName does not exist");
		}

		String serviceName = ctoRequest.getStringValue(Constant.STR_SERVICE_NAME);
		if (!this.serviceMap.containsKey(serviceName)) {
			return Return.valueOfFail("servicebus not found " + serviceName + " Service");
		}
		String transName = ctoRequest.getStringValue(Constant.STR_TRANS_NAME);
		if (!this.transMap.containsKey(transName)) {
			return Return.valueOfFail(serviceName + " not found " + transName + " Trans");
		}
		return Return.OK;
	}

	public Return beforeExecute(CTORequest ctoRequest, CTOResponse ctoResponse) {
		return Return.OK;
	}

	@SuppressWarnings("unchecked")
	private void exceptionExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		List<Connection> connList = (List<Connection>) ctoRequest.getObjectValue(Constant.CONNECTIONS);
		if (connList == null) {
			return;
		}
		for (Connection conn : connList) {
			if (conn != null) {
				if (!conn.isClosed()) {
					if (!conn.getAutoCommit()) {
						conn.rollback();
					}
					conn.close();
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	public Return afterExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		List<Connection> connList = (List<Connection>) ctoRequest.getObjectValue(Constant.CONNECTIONS);
		if (connList == null) {
			return null;
		}
		for (Connection conn : connList) {
			if (conn != null) {
				if (!conn.isClosed()) {
					if (!conn.getAutoCommit()) {
						conn.commit();
						conn.setAutoCommit(true);
					}
					conn.close();
				}
			}
		}
		return Return.OK;
	}

	public IDataEngine getSingeDataEngine() {
		return singeDataEngine;
	}

	public void setSingeDataEngine(IDataEngine singeDataEngine) {
		this.singeDataEngine = singeDataEngine;
	}

	public IDataEngine getWriteDataEngine() {
		return writeDataEngine;
	}

	public void setWriteDataEngine(IDataEngine writeDataEngine) {
		this.writeDataEngine = writeDataEngine;
	}

	public IDataEngine getReadDataEngine() {
		return readDataEngine;
	}

	public void setReadDataEngine(IDataEngine readDataEngine) {
		this.readDataEngine = readDataEngine;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public Map<String, String> getPropertyMap() {
		return propertyMap;
	}

	public Map<String, String> getGlobalParameterMap() {
		return globalParameterMap;
	}

	public Map<String, Map<String, String>> getServiceParameterMap() {
		return serviceParameterMap;
	}

	public Map<String, CycleMap<String, IDataEngine>> getDataSourceGroupMap() {
		return dataSourceGroupMap;
	}

	public Map<String, Service> getServiceMap() {
		return serviceMap;
	}

	public Map<String, Trans> getTransMap() {
		return transMap;
	}

	public CTO getCtoHadoopGroup() {
		return ctoHadoopGroup;
	}

	public ServiceBusConfig getServiceBusConfig() {
		return serviceBusConfig;
	}

}