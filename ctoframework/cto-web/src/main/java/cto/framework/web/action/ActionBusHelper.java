package cto.framework.web.action;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
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
import cto.framework.core.util.Resources;
import cto.framework.core.util.StringHelper;
import cto.framework.core.util.Utility;
import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.ActionPlugin;
import cto.framework.web.action.plugin.schema.Trans;
import cto.framework.web.action.schema.ActionBusConfig;
import cto.framework.web.action.schema.ActionPluginConfig;
import cto.framework.web.action.schema.HadoopServer;
import cto.framework.web.action.schema.HadoopServerGroup;
import cto.framework.web.action.schema.ImportResource;
import cto.framework.web.action.schema.Parameter;
import cto.framework.web.action.schema.PluginXMLResource;

public class ActionBusHelper {

	private static Logger logger = Logger.getLogger(ActionBus.class);

	/***
	 * 解析服务总线
	 * 
	 * @param strXML
	 * @return
	 * @throws Exception
	 */
	public static ActionBusConfig fromActionFramworkXML(String strXML) throws Exception {
		StringReader reader = null;
		try {
			reader = new StringReader(strXML);
			ActionBusConfig actionBusConfig = ActionBusConfig.unmarshal(reader);
			return actionBusConfig;
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
	public static ActionPlugin fromActionluginXML(String strXML) throws Exception {
		StringReader reader = null;
		try {
			reader = new StringReader(strXML);
			ActionPlugin actionPlugin = ActionPlugin.unmarshal(reader);
			return actionPlugin;
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
	public static void initImportSource(ActionBusConfig actionBusConfig, Map<String, String> propertyMap) throws Exception {
		Properties properties = new Properties();
		int importResourceCount = actionBusConfig.getImportResourceCount();
		if (importResourceCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化导入资源......");
			}
			ImportResource[] importResources = actionBusConfig.getImportResource();
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
	public static void initGlobalParameter(ActionBusConfig actionBusConfig, Map<String, String> parameterMap, Map<String, String> propertyMap) throws Exception {
		int nParameterCount = actionBusConfig.getParameterCount();
		if (nParameterCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化全局参数......");
			}
			for (int i = 0; i < nParameterCount; ++i) {
				Parameter para = actionBusConfig.getParameter(i);
				parameterMap.put(para.getName(), ParameterUtils.analyzePropertyValue(para.getValue(), propertyMap));
			}
			if (logger.isInfoEnabled()) {
				logger.info(" init parameterMap >>> " + parameterMap);
			}
		}
	}

	/***
	 * 初始化服务插件
	 * 
	 * @param serviceBusConfig
	 * @param serviceMap
	 * @throws Exception
	 */
	public static void initActionPlugin(ActionBusConfig actionBusConfig, Map<String, Action> serviceMap, Map<String, Trans> actionTransMap, Map<String, Map<String, String>> parameterMap,
			Map<String, String> propertyMap) throws Exception {
		ActionPluginConfig servicePluginConfig = actionBusConfig.getActionPluginConfig();
		if (servicePluginConfig != null) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化服务插件......");
			}
			String autoScanPaths = ParameterUtils.analyzePropertyValue(servicePluginConfig.getAutoScanPath(), propertyMap);
			if (autoScanPaths != null) {
				doScan(parameterMap, propertyMap, serviceMap, actionTransMap, autoScanPaths.split(","));
			}
			int pluginXMLResourceCount = servicePluginConfig.getPluginXMLResourceCount();
			if (pluginXMLResourceCount > 0) {
				PluginXMLResource[] pluginXMLResources = servicePluginConfig.getPluginXMLResource();
				for (PluginXMLResource pluginXMLResource : pluginXMLResources) {
					String path = ParameterUtils.analyzePropertyValue(pluginXMLResource.getPath(), propertyMap);
					initAction(path, parameterMap, propertyMap, serviceMap, actionTransMap);
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
	private static void doScan(Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Action> serviceMap, Map<String, Trans> actionTransMap,
			String... autoScanPaths) throws Exception {
		if (autoScanPaths == null) {
			return;
		}
		for (String scanPath : autoScanPaths) {
			String packageSearchPath = StringHelper.convertClassNameToResourcePath(scanPath);
			URL url = Thread.currentThread().getContextClassLoader().getResource(packageSearchPath);
			if(url == null){
				throw new RuntimeException("没有找到 " + packageSearchPath);
			}
			String scanDirectoryPath = url.getPath();
			scanDirectory(scanDirectoryPath, parameterMap, propertyMap, serviceMap, actionTransMap);
		}
	}

	/***
	 * 扫描目录
	 * 
	 * @param path
	 * @param serviceMap
	 * @throws Exception
	 */
	private static void scanDirectory(String path, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Action> serviceMap,
			Map<String, Trans> actionTransMap) throws Exception {
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
					initAction(file.getPath(), parameterMap, propertyMap, serviceMap, actionTransMap);
				}
			} else if (file.isDirectory()) {
				scanDirectory(file.getPath(), parameterMap, propertyMap, serviceMap, actionTransMap);
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
	private static void initAction(String path, Map<String, Map<String, String>> parameterMap, Map<String, String> propertyMap, Map<String, Action> actionMap,
			Map<String, Trans> actionTransMap) throws Exception {
		if (path == null) {
			return;
		}
		String actionPluginXml = Utility.readTextFile(path, Constant.ENCODING);
		if (actionPluginXml == null) {
			actionPluginXml = Utility.readTextResource(path, Constant.ENCODING);
		}
		if (actionPluginXml == null) {
			throw new RuntimeException("在classpath下,没有找到" + path + "文件" + ",请检查Framework配置");
		}
		ActionPlugin actionPlugin = ActionBusHelper.fromActionluginXML(actionPluginXml);
		Action action = actionPlugin.getAction();
		if (action == null) {
			return;
		}
		if (logger.isInfoEnabled()) {
			logger.info("init Service >>> " + action.getName());
		}
		Trans[] transs = action.getTrans();
		if (transs == null) {
			return;
		}
		for (Trans actionTrans : transs) {
			actionTransMap.put(actionTrans.getName(), actionTrans);
			if (logger.isInfoEnabled()) {
				logger.info("init ActionTrans >>> " + actionTrans.getName());
			}
		}
		actionMap.put(action.getName(), action);

		int parameterCount = action.getParameterCount();
		if (parameterCount > 0) {
			cto.framework.web.action.plugin.schema.Parameter[] parameters = action.getParameter();
			Map<String, String> actionParameterMap = new HashMap<String, String>();
			for (cto.framework.web.action.plugin.schema.Parameter parameter : parameters) {
				String parameterName = parameter.getName();
				String parameterValue = parameter.getValue();
				if (!StringHelper.isNotBlank(parameterName)) {
					throw new RuntimeException("<Parameter name='' /> name is not null");
				}
				actionParameterMap.put(parameterName, ParameterUtils.analyzePropertyValue(parameterValue, propertyMap));
			}
			parameterMap.put(action.getName(), actionParameterMap);
		}
	}

	/***
	 * 初始化Hadoop
	 * 
	 * @param serviceBusConfig
	 * @param ctoHadoopGroup
	 * @param propertyMap
	 */
	public static void initHadoopGroupServer(ActionBusConfig actionBusConfig, CTO ctoHadoopGroup, Map<String, String> propertyMap) {
		int hadoopServerGroupCount = actionBusConfig.getHadoopServerGroupCount();
		if (hadoopServerGroupCount > 0) {
			if (logger.isInfoEnabled()) {
				logger.info("正在初始化HadoopServerGroup......");
			}
			HadoopServerGroup[] hadoopServerGroups = actionBusConfig.getHadoopServerGroup();
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
