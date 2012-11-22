/**
 * 
 */
package cto.framework.web.service.support;

import cto.framework.core.Return;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;
import cto.framework.service.IServiceBus;
import cto.framework.service.ServiceBus;
import cto.framework.service.schema.ServiceBusConfig;
import cto.framework.web.annotation.Service;
import cto.framework.web.annotation.Trans;
import cto.framework.web.service.IFrameworkService;

/**
 * @author PeterTan
 * 
 */
@Service
public class IFrameworkServiceSupport implements IFrameworkService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3566946459362398653L;
	private ServiceBus serviceBus;

	@Trans("adminMain")
	public Return getServiceBusConfig(CTORequest ctoRequest, CTOResponse ctoResponse) {
		return Return.OK;
	}

	@Trans("adminIndex")
	public Return getFrameworkInfo(CTORequest ctoRequest, CTOResponse ctoResponse) {
		ServiceBusConfig serviceBusConfig = serviceBus.getServiceBusConfig();
		ctoResponse.setStringValue("defaultUseCacheGroup", serviceBusConfig.getDefaultUseCacheGroup());
		ctoResponse.setStringValue("defaultUseHadoopGroup", serviceBusConfig.getDefaultUseHadoopGroup());
		ctoResponse.setObjectValue("cacheGroup", serviceBusConfig.getMemCacheServerGroup());
		ctoResponse.setObjectValue("cacheManager", serviceBus.getCacheManager());
		ctoResponse.setObjectValue("hadoopGroup", serviceBus.getCtoHadoopGroup());
		ctoResponse.setObjectValue("dataSourceGroup", serviceBus.getDataSourceGroupMap());
		ctoResponse.setObjectValue("property", serviceBus.getPropertyMap());
		ctoResponse.setObjectValue("readDataEngine", serviceBus.getReadDataEngine());
		ctoResponse.setObjectValue("service", serviceBus.getServiceMap());
		ctoResponse.setObjectValue("serviceParameter", serviceBus.getServiceParameterMap());
		ctoResponse.setObjectValue("singeDataEngine", serviceBus.getSingeDataEngine());
		ctoResponse.setObjectValue("trans", serviceBus.getTransMap());
		ctoResponse.setObjectValue("writeDataEngine", serviceBus.getWriteDataEngine());
		return Return.OK;
	}

	public void setIServiceBus(IServiceBus serviceBus) {
		this.serviceBus = (ServiceBus) serviceBus;
	}

}
