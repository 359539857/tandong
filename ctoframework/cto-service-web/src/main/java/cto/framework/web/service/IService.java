/**
 * 
 */
package cto.framework.web.service;

import java.io.Serializable;

import cto.framework.service.IServiceBus;

/**
 * @author PeterTan
 * 
 */
public interface IService extends Serializable {

	public void setIServiceBus(IServiceBus serviceBus);
}
