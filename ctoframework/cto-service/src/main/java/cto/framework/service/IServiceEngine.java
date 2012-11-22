/**
 * 
 */
package cto.framework.service;

import java.io.Serializable;
import java.util.Map;

import cto.framework.core.Return;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.Trans;

/**
 * @author PeterTan
 * 
 */
public interface IServiceEngine extends Serializable {

	public void setPropertyMap(Map<String, String> propertyMap);

	public void setDataSourceGroupMap(Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap);

	public void setServiceMap(Map<String, Service> serviceMap);

	public void setServiceBus(ServiceBus serviceBus);

	public void setTransMap(Map<String, Trans> actionMap);

	public Return processAction(CTORequest cdoRequest, CTOResponse ctoResponse) throws Exception;

	public void setCacheManager(CacheManager cacheManager);
}
