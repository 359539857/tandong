package cto.framework.service.task;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import cto.framework.core.CTO;
import cto.framework.service.ServiceBus;
import cto.framework.service.helper.ServiceBusHelper;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.Trans;

public class DynamicListenerConfigTask extends AbstractTask {

	private ServiceBus serviceBus;
	private Map<String, Service> serviceMap;
	private Map<String, Trans> transMap;
	private Map<String, Map<String, String>> serviceParameterMap;
	private Map<String, String> propertyMap;
	private CTO servicePathCTO;
	private static long oldModifiedTime = 0;
	private long intervalTime = 1000;

	public DynamicListenerConfigTask(ServiceBus serviceBus, CTO servicePathCTO, Map<String, Service> serviceMap, Map<String, Trans> transMap, Map<String, Map<String, String>> serviceParameterMap,
			Map<String, String> propertyMap, long intervalTime) {
		this.serviceBus = serviceBus;
		this.servicePathCTO = servicePathCTO;
		this.serviceMap = serviceMap;
		this.transMap = transMap;
		this.serviceParameterMap = serviceParameterMap;
		this.propertyMap = propertyMap;
		if (intervalTime > 0) {
			this.intervalTime = intervalTime;
		}
	}

	@Override
	public void execute() throws Exception {

		while (true) {
			Thread.sleep(intervalTime);
			if (servicePathCTO != null) {
				Iterator<String> iterator = servicePathCTO.keys().iterator();
				while (iterator.hasNext()) {
					String name = iterator.next();
					String value = servicePathCTO.getStringValue(name);
					if (this.isFileUpdate(value)) {
						// if (name.equals("ActionFramework")) {
						// serviceBus.start(value);
						// } else {
						try {
							ServiceBusHelper.updateService(value, servicePathCTO, serviceParameterMap, propertyMap, serviceMap, transMap);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						// }
					}
				}
			}
		}
	}

	public boolean isFileUpdate(String file) {
		File $file = new File(file);
		long currModifiedTime = $file.lastModified();
		if (oldModifiedTime == 0) {
			oldModifiedTime = currModifiedTime;
		}
		if (currModifiedTime > oldModifiedTime) {
			oldModifiedTime = currModifiedTime;
			return true;
		}
		return false;
	}
}
