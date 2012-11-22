/**
 * 
 */
package cto.framework.web.service;

import cto.framework.core.Return;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;

/**
 * @author PeterTan
 * 
 */
public interface IFrameworkService extends IService {

	public Return getServiceBusConfig(CTORequest ctoRequest,CTOResponse ctoResponse);
}
