/**
 * 
 */
package cto.framework.web.action;

import cto.framework.core.Return;

/**
 * @author PeterTan
 * 
 */
public interface IActionBus {

	public void start(String actionBusConfigXml) throws Exception;

	public void init(String actionBusConfigXml) throws Exception;

	public Return execute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return validator(CTORequest ctoRequest);

	public Return beforeExecute(CTORequest ctoRequest, CTOResponse ctoResponse);

	public Return afterExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void stop() throws Exception;
}
