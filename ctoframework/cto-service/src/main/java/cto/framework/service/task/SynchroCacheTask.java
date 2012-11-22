/**
 * 
 */
package cto.framework.service.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.service.CTOResponse;
import cto.framework.service.IDataEngine;
import cto.framework.service.cache.memcache.CacheManager;

/**
 * @author PeterTan
 * 
 */
public class SynchroCacheTask extends AbstractTask {

	private String table;
	private IDataEngine dataEngine;

	public SynchroCacheTask(String table, IDataEngine dataEngine) {
		this.table = table;
		this.dataEngine = dataEngine;
	}

	@Override
	public void execute() throws Exception {
		CacheManager cacheManager = CacheManager.getInstance();
		CTO cacheCTO = (CTO) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), Constant.CACHE_KEY);
		if (cacheCTO != null && cacheCTO.length() > 0) {
			Iterator<String> iterator = cacheCTO.keys().iterator();
			while (iterator.hasNext()) {
				String cacheKey = iterator.next();
				CTO value = cacheCTO.getCTOValue(cacheKey);
				String sql = value.getStringValue("sql");
				int sqlQueryType = value.getIntegerValue("sqlQueryType");
				String outputId = value.getStringValue("outputId");
				if (sql.contains(table) && outputId != null) {
					CTO ctoResponse = new CTOResponse();
					CTO sqlParams = value.getCTOValue("sqlParams");
					List<String> $sqlParams = new ArrayList<String>();
					Iterator<String> keys = sqlParams.keys().iterator();
					while (keys.hasNext()) {
						String paramKey = keys.next();
						$sqlParams.add(paramKey);
					}
					dataEngine.executeSQLQuery(sql, outputId, $sqlParams, sqlParams, ctoResponse,sqlQueryType);
					cacheManager.put(cacheManager.getDefaultUseCacheGroup(),cacheKey, sqlParams.getObjectValue(outputId));
				}
			}
		}
	}
}
