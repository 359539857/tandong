package cto.framework.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.core.util.StringHelper;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.helper.EngineHelper;
import cto.framework.service.helper.ExceptionHelper;
import cto.framework.service.plugin.schema.Field;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.plugin.schema.TransTypeChoice;
import cto.framework.service.plugin.schema.Validator;

public class ServiceEngine implements IServiceEngine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140544333828161339L;

	private static Logger logger = Logger.getLogger(ServiceEngine.class);

	private Map<String, String> propertyMap;
	private Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap;
	private Map<String, Service> serviceMap;
	private Map<String, Trans> transMap;
	private ServiceBus serviceBus;

	private ITransEngine transEngine;
	private CacheManager cacheManager;

	public ServiceEngine() {
		propertyMap = new HashMap<String, String>();
		dataSourceGroupMap = new HashMap<String, CycleMap<String, IDataEngine>>();
		serviceMap = new HashMap<String, Service>();
		transMap = new HashMap<String, Trans>();
		transEngine = new TransEngine();
	}

	public ServiceEngine(Map<String, String> propertyMap, Map<String, String> globalParameterMap, Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap, Map<String, Service> serviceMap,
			Map<String, Trans> transMap) {
		this.setPropertyMap(propertyMap);
		this.dataSourceGroupMap.putAll(dataSourceGroupMap);
		this.serviceMap.putAll(serviceMap);
		this.transMap.putAll(transMap);
	}

	public Return processAction(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String serviceName = ctoRequest.getStringValue(Constant.STR_SERVICE_NAME);
		String actionName = ctoRequest.getStringValue(Constant.STR_TRANS_NAME);
		Service service = serviceMap.get(serviceName);

		Trans trans = transMap.get(actionName);
		if (logger.isInfoEnabled()) {
			logger.info("processing " + service.getName() + "." + trans.getName());
		}

		if(StringHelper.isNotBlank(trans.getDataSource())){
			ctoRequest.setStringValue(Constant.DATASOURCE, trans.getDataSource());
		}
		if(StringHelper.isNotBlank(trans.getCacheGroupId())){
			ctoRequest.setStringValue(Constant.CACHEGROUP, trans.getCacheGroupId());
		}

		// 验证接口参数
		Validator validator = trans.getValidator();
		if (validator != null) {
			int fieldCount = validator.getFieldCount();
			if (fieldCount > 0) {
				for (int i = 0; i < fieldCount; i++) {
					Field field = validator.getField(i);
					cto.framework.service.plugin.schema.Return $return = EngineHelper.validator(field, ctoRequest);
					Return rtn = Return.valueOf($return.getCode(), $return.getText(), $return.getInfo());
					if (!Return.executeSuccess(rtn)) {
						return rtn;
					}
				}
			}
		}

		transEngine.setDataSourceGroupMap(dataSourceGroupMap);
		transEngine.setPropertyMap(propertyMap);
		transEngine.setServiceMap(serviceMap);
		transEngine.setTransMap(transMap);
		transEngine.setServiceBus(serviceBus);
		transEngine.setCacheManager(cacheManager);
		TransTypeChoice transTypeChoice = trans.getTransTypeChoice();
		if (transTypeChoice != null) {
			int actionTransTypeChoiceItemCount = transTypeChoice.getTransTypeChoiceItemCount();
			if (actionTransTypeChoiceItemCount > 0) {
				cto.framework.service.plugin.schema.Return $return = transEngine.onActionItem(transTypeChoice.getTransTypeChoiceItem(), ctoRequest, ctoResponse);
				Return rtn = Return.valueOf($return.getCode(), $return.getText(), $return.getInfo());
				if (Return.executeSuccess(rtn)) {
					ExceptionHelper.throwRuntimeException(trans.getThrow(), propertyMap);
				}
				return rtn;
			}
		}

		this.dataSourceGroupMap.clear();
		this.propertyMap.clear();
		this.serviceMap.clear();
		this.transMap.clear();
		return Return.OK;
	}

	public void setDataSourceGroupMap(Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap) {
		this.dataSourceGroupMap.putAll(dataSourceGroupMap);
	}

	public void setServiceMap(Map<String, Service> serviceMap) {
		this.serviceMap.putAll(serviceMap);
	}

	public void setTransMap(Map<String, Trans> transMap) {
		this.transMap.putAll(transMap);
	}

	public void setPropertyMap(Map<String, String> propertyMap) {
		this.propertyMap.putAll(propertyMap);
	}

	public void setServiceBus(ServiceBus serviceBus) {
		this.serviceBus = serviceBus;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
}
