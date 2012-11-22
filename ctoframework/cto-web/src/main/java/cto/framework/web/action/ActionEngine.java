package cto.framework.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.Field;
import cto.framework.web.action.plugin.schema.Trans;
import cto.framework.web.action.plugin.schema.TransTypeChoice;
import cto.framework.web.action.plugin.schema.Validator;

public class ActionEngine implements IActionEngine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140544333828161339L;

	private static Logger logger = Logger.getLogger(ActionEngine.class);

	private Map<String, String> propertyMap;
	private Map<String, Action> actionMap;
	private Map<String, Trans> transMap;
	private ITransEngine transEngine;
	private ActionBus actionBus;

	public ActionEngine() {
		propertyMap = new HashMap<String, String>();
		actionMap = new HashMap<String, Action>();
		transMap = new HashMap<String, Trans>();
		transEngine = new TransEngine();
	}

	public ActionEngine(Map<String, String> propertyMap, Map<String, String> globalParameterMap, Map<String, Action> serviceMap, Map<String, Trans> transMap) {
		this.setPropertyMap(propertyMap);
		this.actionMap.putAll(actionMap);
		this.transMap.putAll(transMap);
	}

	public Return processAction(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String actionName = ctoRequest.getStringValue(Constant.STR_ACTION_NAME);
		String transName = ctoRequest.getStringValue(Constant.STR_TRANS_NAME);
		Action action = actionMap.get(actionName);

		Trans trans = transMap.get(transName);
		if (logger.isInfoEnabled()) {
			logger.info("processing " + action.getName() + "." + trans.getName());
		}

		// 验证接口参数
		Validator validator = trans.getValidator();
		int fieldCount = validator.getFieldCount();
		if (fieldCount > 0) {
			for (int i = 0; i < fieldCount; i++) {
				Field field = validator.getField(i);
				cto.framework.web.action.plugin.schema.Return $return = EngineHelper.validator(field, ctoRequest);
				Return rtn = Return.valueOf($return.getCode(), $return.getText(), $return.getInfo());
				if (!Return.executeSuccess(rtn)) {
					return rtn;
				}
			}
		}

		transEngine.setPropertyMap(propertyMap);
		transEngine.setActionMap(actionMap);
		transEngine.setTransMap(transMap);
		transEngine.setActionBus(actionBus);
		TransTypeChoice actionTransTypeChoice = trans.getTransTypeChoice();
		if (actionTransTypeChoice != null) {
			int actionTransTypeChoiceItemCount = actionTransTypeChoice.getTransTypeChoiceItemCount();
			if (actionTransTypeChoiceItemCount > 0) {
				cto.framework.web.action.plugin.schema.Return $return = transEngine.onActionItem(actionTransTypeChoice.getTransTypeChoiceItem(), ctoRequest, ctoResponse);
				Return rtn = Return.valueOf($return.getCode(), $return.getText(), $return.getInfo());
				if (Return.executeSuccess(rtn)) {
					ExceptionHelper.throwRuntimeException(trans.getThrow(), propertyMap);
				}
				return rtn;
			}
		}

		this.propertyMap.clear();
		this.actionMap.clear();
		this.transMap.clear();
		return Return.OK;
	}

	public void setActionMap(Map<String, Action> serviceMap) {
		this.actionMap.putAll(actionMap);
	}

	public void setTransMap(Map<String, Trans> transMap) {
		this.transMap.putAll(transMap);
	}

	public void setPropertyMap(Map<String, String> propertyMap) {
		this.propertyMap.putAll(propertyMap);
	}

	public void setActionBus(ActionBus actionBus) {
		this.actionBus = actionBus;
	}

}
