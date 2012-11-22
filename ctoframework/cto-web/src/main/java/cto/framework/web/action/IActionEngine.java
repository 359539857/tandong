/**
 * 
 */
package cto.framework.web.action;

import java.io.Serializable;
import java.util.Map;

import cto.framework.core.Return;
import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.Trans;

/**
 * @author PeterTan
 * 
 */
public interface IActionEngine extends Serializable {

	public void setPropertyMap(Map<String, String> propertyMap);

	public void setActionMap(Map<String, Action> actionMap);

	public void setActionBus(ActionBus actionBus);

	public void setTransMap(Map<String, Trans> transMap);

	public Return processAction(CTORequest cdoRequest, CTOResponse ctoResponse) throws Exception;

}
