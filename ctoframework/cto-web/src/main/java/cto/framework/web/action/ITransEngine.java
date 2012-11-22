/**
 * 
 */
package cto.framework.web.action;

import java.io.Serializable;
import java.util.Map;

import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.Call;
import cto.framework.web.action.plugin.schema.For;
import cto.framework.web.action.plugin.schema.IfElseIfGroup;
import cto.framework.web.action.plugin.schema.Log;
import cto.framework.web.action.plugin.schema.Out;
import cto.framework.web.action.plugin.schema.Return;
import cto.framework.web.action.plugin.schema.SetValue;
import cto.framework.web.action.plugin.schema.Throw;
import cto.framework.web.action.plugin.schema.Trans;
import cto.framework.web.action.plugin.schema.TransTypeChoiceItem;
import cto.framework.web.action.plugin.schema.TryCatchFinallyGroup;

/**
 * @author PeterTan
 * 
 */
public interface ITransEngine extends Serializable {

	public void setActionBus(ActionBus actionBus);

	public void setPropertyMap(Map<String, String> propertyMap);

	public void setActionParameterMap(Map<String, String> serviceParameterMap);

	public void setTransMap(Map<String, Trans> actionTransMap);

	public void setActionMap(Map<String, Action> serviceMap);

	public void onActionThrow(Throw $throw, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionOut(Out out, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionFor(For $for, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionLog(Log log, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionTryCatchFinallyGroup(TryCatchFinallyGroup tryCatchFinallyGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionCall(Call call, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionIfElseIfGroup(IfElseIfGroup ifElseIfGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionReturn(Return $return, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionSetValue(SetValue setValue, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionItem(TransTypeChoiceItem[] transTypeChoiceItem, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

}
