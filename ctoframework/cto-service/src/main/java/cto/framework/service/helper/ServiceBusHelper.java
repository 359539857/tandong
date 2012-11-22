package cto.framework.service.helper;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.ReflectUtils;
import cto.framework.core.util.Resources;
import cto.framework.core.util.StringHelper;
import cto.framework.core.util.Utility;
import cto.framework.service.CycleMap;
import cto.framework.service.DataEngine;
import cto.framework.service.IDataEngine;
import cto.framework.service.MethodType;
import cto.framework.service.ServiceBus;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.ServicePlugin;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.schema.DataSource;
import cto.framework.service.schema.DataSourceGroup;
import cto.framework.service.schema.DataSourceType;
import cto.framework.service.schema.HadoopServer;
import cto.framework.service.schema.HadoopServerGroup;
import cto.framework.service.schema.ImportResource;
import cto.framework.service.schema.MemCacheServerGroup;
import cto.framework.service.schema.Parameter;
import cto.framework.service.schema.PluginXMLResource;
import cto.framework.service.schema.Property;
import cto.framework.service.schema.ReadWriteDataSource;
import cto.framework.service.schema.ServiceBusConfig;
import cto.framework.service.schema.ServicePluginConfig;
import cto.framework.service.schema.SingleDataSource;
import cto.framework.service.schema.SystemDataSourceGroup;

public class ServiceBusHelper {

	private static Logger logger = Logger.getLogger(ServiceBus.class);

	/***
	 * 解析服务总线
	 * 
	 * @param strXML
	 * @return
	 * @throws Exception
	 */
	public static ServiceBusConfig fromFramworkXML(String strXML) throws Exception {
		StringReader reader = null;
		try {
			reader = new StringReader(strXML);
			ServiceBusConfig serviceBusConfig = ServiceBusConfig.unmarshal(reader);
			return serviceBusConfig;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
			}
		}
	}

	/***
	 * 解析服务插件
	 * 
	 * @param strXML
	 * @return
	 * @throws Exception
	 */
	public static ServicePlugin fromServicePluginXML(String strXML) throws Exception {
		StringReader reader = null;
		try {
			reader = new StringReader(strXML);
			ServicePlugin servicePlugin = ServicePlugin.unmarshal(reader);
			return servicePlugin;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
			}
		}
	}

	/***
	 * 导入资源文件
	 * 
	 * @param serviceBusConfig
	 * @param propertyMap
	 * @throws Exception
	 */
	public static void initImportSource(ServiceBusConfig serviceBusConfig, Map<String, String> propertyMap) throws Exception {
		Properties properties = new Properties();
		int importResourceCount = serviceBusConfig.getImportResourceCount();
		if (importResourceCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化导入资源......");
			}
			ImportResource[] importResources = serviceBusConfig.getImportResource();
			for (ImportResource importResource : importResources) {
				String path = importResource.getPath();
				if (logger.isInfoEnabled()) {
					logger.info(" init import source file >>> " + path);
				}
				InputStream stream = Resources.getResourceAsStream(path);
				InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
				properties.load(reader);
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (Exception e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
				if (stream != null) {
					try {
						stream.close();
					} catch (Exception e) {
						logger.error(ExceptionUtils.getFullStackTrace(e));
					}
				}
				if (!properties.isEmpty()) {
					Iterator<Object> iterator = properties.keySet().iterator();
					while (iterator.hasNext()) {
						String key = (String) iterator.next();
						String value = (String) properties.get(key);
						propertyMap.put(key, value);
					}
				}
			}
		}
	}

	/***
	 * 初始全局参数
	 * 
	 * @param serviceBusConfig
	 * @param parameterMap
	 * @param propertyMap
	 * @throws Exception
	 */
	public static void initGlobalParameter(ServiceBusConfig serviceBusConfig, Map<String, String> parameterMap, Map<String, String> propertyMap) throws Exception {
		int nParameterCount = serviceBusConfig.getParameterCount();
		if (nParameterCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化全局参数......");
			}
			for (int i = 0; i < nParameterCount; ++i) {
				Parameter para = serviceBusConfig.getParameter(i);
				parameterMap.put(para.getName(), ParameterUtils.analyzePropertyValue(para.getValue(), propertyMap));
			}
			if (logger.isInfoEnabled()) {
				logger.info(" init parameterMap >>> " + parameterMap);
			}
		}
	}

	/***
	 * 初始化数据源
	 * 
	 * @param serviceBus
	 * @param serviceBusConfig
	 * @param dataSourceGroupMap
	 * @param propertyMap
	 * @throws Exception
	 */
	public static void initDataSource(ServiceBus serviceBus, ServiceBusConfig serviceBusConfig, Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap, Map<String, String> propertyMap)
			throws Exception {
		SystemDataSourceGroup systemDataSourceGroup = serviceBusConfig.getSystemDataSourceGroup();
		if (systemDataSourceGroup != null) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化数据源......");
			}
			int dataSourceGroupCount = systemDataSourceGroup.getDataSourceGroupCount();
			if (dataSourceGroupCount > 0) {
				DataSourceGroup[] dataSourceGroups = systemDataSourceGroup.getDataSourceGroup();
				for (int i = 0; i < dataSourceGroups.length; ++i) {
					CycleMap<String, IDataEngine> clDataEngine = initDataSourceGroup(dataSourceGroups[i], propertyMap);
					if (logger.isInfoEnabled()) {
						logger.info(" init DataSourceGroup >>> " + dataSourceGroups[i].getId());
					}
					dataSourceGroupMap.put(dataSourceGroups[i].getId(), clDataEngine);
				}
			}
			SingleDataSource singleDataSource = systemDataSourceGroup.getSingleDataSource();
			if (singleDataSource != null) {
				if (logger.isInfoEnabled()) {
					logger.info(" init SingleDataSource >>> " + singleDataSource.getId());
				}
				serviceBus.setSingeDataEngine(initDataSource(singleDataSource, propertyMap));
			}

			ReadWriteDataSource readWriteDataSource = systemDataSourceGroup.getReadWriteDataSource();
			if (readWriteDataSource != null) {
				initReadWriteDataSource(readWriteDataSource, propertyMap, serviceBus);
			}
		}
	}

	/***
	 * 初始化读写数据源
	 * 
	 * @param readWriteDataSource
	 * @param propertyMap
	 * @param serviceBus
	 * @throws Exception
	 */
	public static void initReadWriteDataSource(ReadWriteDataSource readWriteDataSource, Map<String, String> propertyMap, ServiceBus serviceBus) throws Exception {
		DataSource[] $readWriteDataSources = readWriteDataSource.getDataSource();
		for (DataSource $readWriteDataSource : $readWriteDataSources) {
			if ($readWriteDataSource.getId().contains("read")) {
				if (logger.isInfoEnabled()) {
					logger.info(" init initReadDataSource >>> " + $readWriteDataSource.getId());
				}
				serviceBus.setReadDataEngine(initDataSource($readWriteDataSource, propertyMap));
			} else if ($readWriteDataSource.getId().contains("write")) {
				if (logger.isInfoEnabled()) {
					logger.info(" init initWriteDataSource >>> " + $readWriteDataSource.getId());
				}
				serviceBus.setWriteDataEngine(initDataSource($readWriteDataSource, propertyMap));
			}
		}
	}

	/***
	 * 初始化单数据源
	 * 
	 * @param singleDataSource
	 * @param propertyMap
	 * @return
	 * @throws Exception
	 */
	public static IDataEngine initDataSource(DataSourceType singleDataSource, Map<String, String> propertyMap) throws Exception {
		IDataEngine dataEngine = new DataEngine();
		String poolClass = ParameterUtils.analyzePropertyValue(singleDataSource.getPoolClass().value(), propertyMap);
		Property[] propertys = singleDataSource.getProperty();
		Class<?> dataSourceClass = Class.forName(poolClass);
		Object dataSourceObject = dataSourceClass.newInstance();
		int nPropertyCount = singleDataSource.getPropertyCount();
		if (nPropertyCount > 0) {
			for (Property property : propertys) {
				String propertyName = property.getName();
				String setMethodName = StringHelper.fieldNameToMethodName(propertyName, MethodType.SET.value());
				Object $value = ParameterUtils.analyzePropertyValue(property.getValue(), propertyMap);
				List<Object> parameters = new ArrayList<Object>();
				parameters.add($value);
				Method setMethod = ReflectUtils.getMethod(dataSourceClass, setMethodName, parameters);
				Class<?>[] clazzs = setMethod.getParameterTypes();
				if (clazzs[0].equals(Integer.class) || clazzs[0].equals(int.class)) {
					setMethod.invoke(dataSourceObject, (Integer) $value);
				} else if (clazzs[0].equals(String.class)) {
					setMethod.invoke(dataSourceObject, $value);
				} else if (clazzs[0].equals(Long.class) || clazzs[0].equals(long.class)) {
					setMethod.invoke(dataSourceObject, (Long) $value);
				} else if (clazzs[0].equals(Boolean.class) || clazzs[0].equals(boolean.class)) {
					setMethod.invoke(dataSourceObject, (Boolean) $value);
				}

			}
		}
		dataEngine.setDataSource((javax.sql.DataSource) dataSourceObject);
		dataEngine.testSQL();
		return dataEngine;
	}

	/***
	 * 初始化数据源列表
	 * 
	 * @param dataSourceGroup
	 * @return
	 * @throws Exception
	 */
	public static CycleMap<String, IDataEngine> initDataSourceGroup(DataSourceGroup dataSourceGroup, Map<String, String> propertyMap) throws Exception {
		CycleMap<String, IDataEngine> clDataEngine = new CycleMap<String, IDataEngine>();
		DataSource[] dataSources = dataSourceGroup.getDataSource();
		List<CTO> ctos = new ArrayList<CTO>();
		for (int i = 0; i < dataSources.length; ++i) {
			CTO cto = new CTO();
			IDataEngine dataEngine = new DataEngine();
			DataSource dataSource = dataSources[i];
			String poolClass = ParameterUtils.analyzePropertyValue(dataSource.getPoolClass().value(), propertyMap);
			Property[] propertys = dataSource.getProperty();
			Class<?> dataSourceClass = Class.forName(poolClass);
			Object dataSourceObject = dataSourceClass.newInstance();
			int nPropertyCount = dataSource.getPropertyCount();
			cto.setObjectValue("id", dataSource.getId());
			cto.setObjectValue("poolClass", poolClass);
			if (nPropertyCount > 0) {
				for (Property property : propertys) {
					String propertyName = property.getName();
					String setMethodName = StringHelper.fieldNameToMethodName(propertyName, MethodType.SET.value());
					Object $value = ParameterUtils.analyzePropertyValue(property.getValue(), propertyMap);
					List<Object> parameters = new ArrayList<Object>();
					parameters.add($value);
					Method setMethod = ReflectUtils.getMethod(dataSourceClass, setMethodName, parameters);
					Class<?>[] clazzs = setMethod.getParameterTypes();
					if (clazzs[0].equals(Integer.class) || clazzs[0].equals(int.class)) {
						setMethod.invoke(dataSourceObject, Integer.valueOf((String) $value));
					} else if (clazzs[0].equals(String.class)) {
						setMethod.invoke(dataSourceObject, $value);
					} else if (clazzs[0].equals(Long.class) || clazzs[0].equals(long.class)) {
						setMethod.invoke(dataSourceObject, Long.valueOf((String) $value));
					} else if (clazzs[0].equals(Boolean.class) || clazzs[0].equals(boolean.class)) {
						setMethod.invoke(dataSourceObject, Boolean.valueOf((String) $value));
					}
					cto.setObjectValue(propertyName, $value);
				}
				ctos.add(cto);
			}
			dataEngine.setDataSource((javax.sql.DataSource) dataSourceObject);
			dataEngine.testSQL();
			clDataEngine.addT(dataSource.getId(), dataEngine);
			if (logger.isInfoEnabled()) {
				logger.info("init DataSourceGroup >>> " + cto);
			}
		}
		return clDataEngine;
	}

	/***
	 * 初始化服务插件
	 * 
	 * @param serviceBusConfig
	 * @param serviceMap
	 * @throws Exception
	 */
	public static void initServicePlugin(ServiceBusConfig serviceBusConfig, Map<String, Service> serviceMap, Map<String, Trans> transMap, Map<String, Map<String, String>> parameterMap,
			Map<String, String> propertyMap, CTO servicePathCTO) throws Exception {
		ServicePluginConfig servicePluginConfig = serviceBusConfig.getServicePluginConfig();
		if (servicePluginConfig != null) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化服务插件......");
			}
			String autoScanPaths = ParameterUtils.analyzePropertyValue(servicePluginConfig.getAutoScanPath(), propertyMap);
			if (autoScanPaths != null) {
				doScan(servicePathCTO, parameterMap, propertyMap, serviceMap, transMap, autoScanPaths.split(","));
			}
			int pluginXMLResourceCount = servicePluginConfig.getPluginXMLResourceCount();
			if (pluginXMLResourceCount > 0) {
				PluginXMLResource[] pluginXMLResources = servicePluginConfig.getPluginXMLResource();
				for (PluginXMLResource pluginXMLResource : pluginXMLResources) {
					String path = ParameterUtils.analyzePropertyValue(pluginXMLResource.getPath(), propertyMap);
					initService(path, servicePathCTO,parameterMap, propertyMap, serviceMap, transMap);
				}
			}
		}
	}

	/***
	 * 扫描目录组
	 * 
	 * @param serviceMap
	 * @param autoScanPaths
	 * @throws Exception
	 */
	public static void doScan(CTO servicePathCTO, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Service> serviceMap,
			Map<String, Trans> transMap, String... autoScanPaths) throws Exception {
		if (autoScanPaths == null) {
			return;
		}
		for (String scanPath : autoScanPaths) {
			String packageSearchPath = StringHelper.convertClassNameToResourcePath(scanPath);
			URL url = Thread.currentThread().getContextClassLoader().getResource(packageSearchPath);
			if (url == null) {
				throw new RuntimeException("没有找到 " + packageSearchPath);
			}
			String scanDirectoryPath = url.getPath();
			scanDirectory(scanDirectoryPath, servicePathCTO, parameterMap, propertyMap, serviceMap, transMap);
		}
	}

	/***
	 * 扫描目录
	 * 
	 * @param path
	 * @param serviceMap
	 * @throws Exception
	 */
	public static void scanDirectory(String path,CTO servicePathCTO, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Service> serviceMap,
			Map<String, Trans> transMap) throws Exception {
		if (path == null) {
			return;
		}
		File _file = new File(path);
		File[] files = _file.listFiles();
		if (files == null)
			return;
		for (File file : files) {
			if (file.isFile()) {
				String fileName = file.getName();
				if (fileName.toLowerCase().endsWith(Constant.DEFAULT_RESOURCE_PATTERN.toLowerCase())) {
					initService(file.getPath(), servicePathCTO, parameterMap, propertyMap, serviceMap, transMap);
				}
			} else if (file.isDirectory()) {
				scanDirectory(file.getPath(), servicePathCTO, parameterMap, propertyMap, serviceMap, transMap);
			} else {
				continue;
			}
		}
	}

	/***
	 * 初始化服务
	 * 
	 * @param path
	 * @param parameterMap
	 * @param propertyMap
	 * @param serviceMap
	 * @param actionTransMap
	 * @throws Exception
	 */
	public static void initService(String path, CTO servicePathCTO, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Service> serviceMap,
			Map<String, Trans> transMap) throws Exception {
		if (path == null) {
			return;
		}
		String servicePluginXml = Utility.readTextFile(path, Constant.ENCODING);
		if (servicePluginXml == null) {
			servicePluginXml = Utility.readTextResource(path, Constant.ENCODING);
		}
		if (servicePluginXml == null) {
			throw new RuntimeException("在classpath下,没有找到" + path + "文件" + ",请检查Framework配置");
		}
		ServicePlugin servicePlugin = ServiceBusHelper.fromServicePluginXML(servicePluginXml);
		Service service = servicePlugin.getService();
		if (service == null) {
			return;
		}
		if (logger.isInfoEnabled()) {
			logger.info("init Service >>> " + service.getName());
		}
		servicePathCTO.setStringValue(service.getName(), path);
		Trans[] transs = service.getTrans();
		if (transs == null) {
			return;
		}
		for (Trans trans : transs) {
			transMap.put(trans.getName(), trans);
			if (logger.isInfoEnabled()) {
				logger.info("init ActionTrans >>> " + trans.getName());
			}
		}
		serviceMap.put(service.getName(), service);

		int parameterCount = service.getParameterCount();
		if (parameterCount > 0) {
			cto.framework.service.plugin.schema.Parameter[] parameters = service.getParameter();
			Map<String, String> serviceParameterMap = new HashMap<String, String>();
			for (cto.framework.service.plugin.schema.Parameter parameter : parameters) {
				String parameterName = parameter.getName();
				String parameterValue = parameter.getValue();
				if (!StringHelper.isNotBlank(parameterName)) {
					throw new RuntimeException("<Parameter name='' /> name is not null");
				}
				serviceParameterMap.put(parameterName, ParameterUtils.analyzePropertyValue(parameterValue, propertyMap));
			}
			parameterMap.put(service.getName(), serviceParameterMap);
		}
	}
	
	
	public static void updateService(String path, CTO servicePathCTO, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Service> serviceMap,
			Map<String, Trans> transMap) throws Exception {
		if (path == null) {
			return;
		}
		String servicePluginXml = Utility.readTextFile(path, Constant.ENCODING);
		if (servicePluginXml == null) {
			servicePluginXml = Utility.readTextResource(path, Constant.ENCODING);
		}
		if (servicePluginXml == null) {
			throw new RuntimeException("在classpath下,没有找到" + path + "文件" + ",请检查Framework配置");
		}
		ServicePlugin servicePlugin = ServiceBusHelper.fromServicePluginXML(servicePluginXml);
		Service service = servicePlugin.getService();
		if (service == null) {
			return;
		}
		if (logger.isInfoEnabled()) {
			logger.info("update Service >>> " + service.getName());
		}
		servicePathCTO.setStringValue(service.getName(), path);
		Trans[] transs = service.getTrans();
		if (transs == null) {
			return;
		}
		for (Trans trans : transs) {
			transMap.put(trans.getName(), trans);
			if (logger.isInfoEnabled()) {
				logger.info("update Trans >>> " + trans.getName());
			}
		}
		serviceMap.put(service.getName(), service);

		int parameterCount = service.getParameterCount();
		if (parameterCount > 0) {
			cto.framework.service.plugin.schema.Parameter[] parameters = service.getParameter();
			Map<String, String> serviceParameterMap = new HashMap<String, String>();
			for (cto.framework.service.plugin.schema.Parameter parameter : parameters) {
				String parameterName = parameter.getName();
				String parameterValue = parameter.getValue();
				if (!StringHelper.isNotBlank(parameterName)) {
					throw new RuntimeException("<Parameter name='' /> name is not null");
				}
				serviceParameterMap.put(parameterName, ParameterUtils.analyzePropertyValue(parameterValue, propertyMap));
			}
			parameterMap.put(service.getName(), serviceParameterMap);
		}
	}

	/***
	 * 初始化缓存
	 * 
	 * @param cacheManager
	 * @param serviceBusConfig
	 * @param propertyMap
	 */
	public static void initCacheContainer(CacheManager cacheManager, ServiceBusConfig serviceBusConfig, Map<String, String> propertyMap) {
		int memCacheServerGroupCount = serviceBusConfig.getMemCacheServerGroupCount();
		if (memCacheServerGroupCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化缓存容器......");
			}
			MemCacheServerGroup[] memCacheServerGroups = serviceBusConfig.getMemCacheServerGroup();
			cacheManager.initMemCacheServer(memCacheServerGroups);
			String defaultUseCacheGroup = serviceBusConfig.getDefaultUseCacheGroup();
			if (StringHelper.isNotBlank(defaultUseCacheGroup)) {
				cacheManager.setDefaultUseCacheGroup(defaultUseCacheGroup);
				if (logger.isInfoEnabled()) {
					logger.info("set defaultUseCacheGroup for " + defaultUseCacheGroup);
				}
			}
		}
	}

	/***
	 * 初始化Hadoop
	 * 
	 * @param serviceBusConfig
	 * @param ctoHadoopGroup
	 * @param propertyMap
	 */
	public static void initHadoopGroupServer(ServiceBusConfig serviceBusConfig, CTO ctoHadoopGroup, Map<String, String> propertyMap) {
		int hadoopServerGroupCount = serviceBusConfig.getHadoopServerGroupCount();
		if (hadoopServerGroupCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化HadoopServerGroup......");
			}
			HadoopServerGroup[] hadoopServerGroups = serviceBusConfig.getHadoopServerGroup();
			for (HadoopServerGroup hadoopServerGroup : hadoopServerGroups) {
				int hadoopServerCount = hadoopServerGroup.getHadoopServerCount();
				if (hadoopServerCount > 0) {
					if (logger.isInfoEnabled()) {
						logger.info("init HadoopServerGroup >>> " + hadoopServerGroup.getId());
					}
					HadoopServer[] hadoopServers = hadoopServerGroup.getHadoopServer();
					List<CTO> ctoHadoopServers = new ArrayList<CTO>();
					for (HadoopServer hadoopServer : hadoopServers) {
						String hadoopName = hadoopServer.getName();
						String hadoopIp = hadoopServer.getIP();
						String hadoopPort = hadoopServer.getProt();
						CTO ctoHadoopServer = new CTO();
						ctoHadoopServer.setStringValue("name", hadoopName);
						ctoHadoopServer.setStringValue("ip", hadoopIp);
						ctoHadoopServer.setStringValue("port", hadoopPort);
						ctoHadoopServers.add(ctoHadoopServer);
						if (logger.isInfoEnabled()) {
							logger.info("init HadoopServer >>> " + ctoHadoopServer);
						}
					}
					ctoHadoopGroup.setCTOArrayValue(hadoopServerGroup.getId(), ctoHadoopServers.toArray(new CTO[1]));
				}
			}
		}
	}
}
