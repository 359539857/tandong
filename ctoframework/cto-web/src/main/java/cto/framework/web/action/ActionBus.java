/**
 * 
 */
package cto.framework.web.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.core.util.StringHelper;
import cto.framework.core.util.Utility;
import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.Trans;
import cto.framework.web.action.schema.ActionBusConfig;

/**
 * @author PeterTan
 * 
 */
public class ActionBus implements IActionBus {

	private static Logger logger = Logger.getLogger(ActionBus.class);

	private static ActionBus actionBus;
	private ActionBusConfig actionBusConfig;
	private IActionEngine actionEngine;

	private Map<String, String> propertyMap;
	private Map<String, String> globalParameterMap;
	private Map<String, Map<String, String>> actionParameterMap;
	private Map<String, Action> actionMap;
	private Map<String, Trans> transMap;
	private CTO ctoHadoopGroup;

	private ActionBus() {
		propertyMap = new HashMap<String, String>();
		globalParameterMap = new HashMap<String, String>();
		actionParameterMap = new HashMap<String, Map<String, String>>();
		actionMap = new HashMap<String, Action>();
		transMap = new HashMap<String, Trans>();
		ctoHadoopGroup = new CTO();
		actionEngine = new ActionEngine();
	}

	public static ActionBus getInstance() {
		if (actionBus == null) {
			actionBus = new ActionBus();
		}
		return actionBus;
	}

	public void init() throws Exception {
		this.init(null);
	}

	public void init(String actionBusConfigPath) throws Exception {
		if (StringHelper.isNotBlank(actionBusConfigPath)) {
			actionBusConfigPath = Constant.DEFAULT_ACTION_FRAMEWORK_CONFIG;
		}
		String actionBusConfigXml = Utility.readTextResource(actionBusConfigPath, "UTF-8");
		if (!StringHelper.isNotBlank(actionBusConfigXml)) {
			throw new RuntimeException("没有找到 " + actionBusConfigPath);
		}
		actionBusConfig = ActionBusHelper.fromActionFramworkXML(actionBusConfigXml);
		// 初始化全局参数
		ActionBusHelper.initImportSource(actionBusConfig, propertyMap);
		ActionBusHelper.initGlobalParameter(actionBusConfig, globalParameterMap, propertyMap);
		ActionBusHelper.initHadoopGroupServer(actionBusConfig, ctoHadoopGroup, propertyMap);
		ActionBusHelper.initActionPlugin(actionBusConfig, actionMap, transMap, actionParameterMap, propertyMap);
		if (logger.isInfoEnabled()) {
			logger.info("actionframework start successfully......");
		}
	}

	@Override
	public Return execute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		Return $return = validator(ctoRequest);
		if (Return.executeSuccess($return)) {
			Return $preReturn = beforeExecute(ctoRequest, ctoResponse);
			if (Return.executeSuccess($preReturn)) {
				String actionName = ctoRequest.getStringValue(Constant.STR_ACTION_NAME);
				Map<String, String> $actionParameterMap = this.actionParameterMap.get(actionName);
				addActonAndGlobalParameterToCTORequest(ctoRequest, $actionParameterMap);// 把全局参数和服务参数添加至CTORequest
				actionEngine.setActionMap(actionMap);
				actionEngine.setTransMap(transMap);
				actionEngine.setPropertyMap(propertyMap);
				actionEngine.setActionBus(this);
				try {
					Return $processReturn = actionEngine.processAction(ctoRequest, ctoResponse);
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

	private void addActonAndGlobalParameterToCTORequest(CTORequest ctoRequest, Map<String, String> $actionParameterMap) {
		Iterator<String> iterator = $actionParameterMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = $actionParameterMap.get(key);
			ctoRequest.setObjectValue(key, value);
		}
		Iterator<String> iterator2 = globalParameterMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator2.next();
			Object value = $actionParameterMap.get(key);
			ctoRequest.setObjectValue(key, value);
		}
	}

	@Override
	public Return validator(CTORequest ctoRequest) {
		if (ctoRequest == null) {
			return Return.valueOfFail("ctoRequest is null");
		}
		if (!ctoRequest.exists(Constant.STR_ACTION_NAME)) {
			return Return.valueOfFail("ctoRequest actionName does not exist");
		}
		if (!ctoRequest.exists(Constant.STR_TRANS_NAME)) {
			return Return.valueOfFail("ctoRequest transName does not exist");
		}

		String actionName = ctoRequest.getStringValue(Constant.STR_ACTION_NAME);
		if (!this.actionMap.containsKey(actionName)) {
			return Return.valueOfFail("actionbus not found " + actionName + " service");
		}
		String transName = ctoRequest.getStringValue(Constant.STR_TRANS_NAME);
		if (!this.transMap.containsKey(actionName)) {
			return Return.valueOfFail(actionName + " not found " + transName + " ActionTrans");
		}
		return Return.OK;
	}

	@Override
	public Return beforeExecute(CTORequest ctoRequest, CTOResponse ctoResponse) {
		return Return.OK;
	}

	@Override
	public Return afterExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		return Return.OK;
	}

	private void exceptionExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
	}

	@Override
	public void stop() throws Exception {

	}

	@Override
	public void start(String actionBusConfigXml) throws Exception {
		this.init(actionBusConfigXml);
	}

}
