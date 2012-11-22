/**
 * 
 */
package cto.framework.web.container;

import java.io.Serializable;

import cto.framework.core.Return;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;

/**
 * @author PeterTan
 * 
 */
public interface Container extends Serializable {

	Return execute(CTORequest ctoRequest, CTOResponse ctoResponse);

	public void start() throws Exception;

	public void stop();

}
