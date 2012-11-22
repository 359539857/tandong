package cto.framework.service.cache.memcache;

import java.util.HashMap;

import net.spy.memcached.MemcachedNode;

import org.apache.log4j.Logger;

import cto.framework.core.Return;
import cto.framework.service.schema.MemCacheServerGroup;

public class CacheManager implements ICacher {
	static Logger logger = Logger.getLogger(CacheManager.class);
	private HashMap<String, CacheClient> hmCacheClient;
	private String defaultUseCacheGroup;
	private static CacheManager cacheManager;

	private CacheManager() {
		this.hmCacheClient = new HashMap<String, CacheClient>(3);
	}

	public static CacheManager getInstance() {
		if (cacheManager == null) {
			cacheManager = new CacheManager();
		}
		return cacheManager;
	}

	public Return initMemCacheServer(MemCacheServerGroup[] memCacheServerGroups) {
		if ((memCacheServerGroups != null) && (memCacheServerGroups.length > 0)) {
			for (MemCacheServerGroup group : memCacheServerGroups) {
				if (logger.isInfoEnabled()) {
					logger.info("init cache group >>> " + group.getId());
				}
				CacheClient cacheClient = new CacheClient();
				Return ret = cacheClient.initMemCach(group);
				if (!Return.executeSuccess(ret)) {
					logger.error(ret.getText());
					return ret;
				}
				if (!cacheClient.testConnection()) {
					throw new RuntimeException("init cache group " + group.getId() + ">>> fail,please check cache congfig information!");
				}
				this.hmCacheClient.put(group.getId(), cacheClient);
			}
		}
		return Return.OK;
	}

	public boolean delete(String cacheServerId, String strKey) throws Exception {
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null)
			return false;
		return cacheClient.deleteCacheValue(strKey);
	}

	public Object get(String cacheServerId, String strKey) throws Exception {
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null)
			return null;
		return cacheClient.getCacheValue(strKey);
	}

	public MemcachedNode getMemcachedNode(String cacheServerId, String strKey) {
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null)
			return null;
		return cacheClient.getMemcachedNode(strKey);
	}

	public boolean put(String cacheServerId, String strKey, Object objValue, int expireTime) throws Exception {
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null)
			return false;
		return cacheClient.putCacheValue(strKey, objValue, expireTime);
	}

	public boolean put(String cacheServerId, String strKey, Object objValue) throws Exception {
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null)
			return false;
		return cacheClient.putCacheValue(strKey, objValue);
	}

	public boolean testConnection(String cacheServerId) {
		if (this.hmCacheClient == null) {
			return false;
		}
		CacheClient cacheClient = (CacheClient) this.hmCacheClient.get(cacheServerId);
		if (cacheClient == null) {
			return false;
		}
		return cacheClient.testConnection();
	}

	public void close() {
		if ((this.hmCacheClient == null)) {
			return;
		}
		try {
			if (this.hmCacheClient.size() > 0) {
				CacheClient[] clients = new CacheClient[this.hmCacheClient.size()];
				this.hmCacheClient.values().toArray(clients);

				for (CacheClient cc : clients) {
					cc.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setDefaultUseCacheGroup(String defaultUseCacheGroup) {
		this.defaultUseCacheGroup = defaultUseCacheGroup;
	}

	public String getDefaultUseCacheGroup() {
		return this.defaultUseCacheGroup;
	}
}