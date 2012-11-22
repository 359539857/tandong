/**
 * 
 */
package cto.framework.service;

import java.io.Serializable;
import java.util.Map;

import cto.framework.core.CTO;
import cto.framework.core.Return;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.schema.ServiceBusConfig;

/**
 * @author PeterTan
 * 
 */
public interface IServiceBus extends Serializable {

	public void start(String applicationConfigPath) throws Exception;

	public void init(String serviceBusConfigXml) throws Exception;

	public Return execute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return validator(CTORequest ctoRequest);

	public Return beforeExecute(CTORequest ctoRequest, CTOResponse ctoResponse);

	public Return afterExecute(CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void stop() throws Exception;

	public CacheManager getCacheManager();

	public Map<String, String> getPropertyMap();

	public Map<String, String> getGlobalParameterMap();

	public Map<String, Map<String, String>> getServiceParameterMap();

	public Map<String, CycleMap<String, IDataEngine>> getDataSourceGroupMap();

	public Map<String, Service> getServiceMap();

	public Map<String, Trans> getTransMap();

	public CTO getCtoHadoopGroup();

	public ServiceBusConfig getServiceBusConfig();
}
