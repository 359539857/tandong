package cto.framework.service;

import java.util.Iterator;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.service.cache.memcache.CacheManager;

/**
 * Hello world!
 * 
 */
public class App {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			ServiceBus.getInstance().init(null);
			CTORequest ctoRequest = new CTORequest("ApplicationService", "addApplication");
			ctoRequest.setStringValue("sName", "谭东");
			ctoRequest.setStringValue("userName", "tandong");
			ctoRequest.setStringValue("password", "123123");
			ctoRequest.setStringValue("valid", "1");
			CTOResponse ctoResponse = new CTOResponse();
			long startTime = System.currentTimeMillis();
			Return $return = ServiceBus.getInstance().execute(ctoRequest, ctoResponse);
			long endTime = System.currentTimeMillis();
			System.out.println("本次请求耗时:" + (endTime - startTime) + "毫秒");
			CacheManager cacheManager = CacheManager.getInstance();
			CTO ctoCache = (CTO) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), Constant.CACHE_KEY);
			if (ctoCache != null) {
				Iterator<String> iterator = ctoCache.keys().iterator();
				while (iterator.hasNext()) {
					CTO[] value = (CTO[]) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), iterator.next());
					int i = 0;
					for (CTO cto : value) {
						System.out.println(cto.toJSONString() + i);
						i++;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
