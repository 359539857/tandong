package cto.framework.service.cache.memcache;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.MemcachedNode;
import net.spy.memcached.ops.OperationException;

import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Return;
import cto.framework.service.schema.CacheServer;
import cto.framework.service.schema.MemCacheServerGroup;
import cto.framework.service.schema.Server;

public class CacheClient {
	static Logger logger = Logger.getLogger(CacheClient.class);
	static int FOREVER = 2000000;
	private ArrayList<MemcachedClient> alCacheClient;
	private static final String strKey = "_CTO_TEST_CONNECTION_";
	private String strId;

	public String getId() {
		return this.strId;
	}

	public boolean putCacheValue(String strCacheKey, Object obj, int nExpireTime) {
		if (strCacheKey == null) {
			return false;
		}
		boolean bResult = true;
		if ((logger.isDebugEnabled()) && (obj != null) && (obj.toString().contains("�"))) {
			logger.debug("乱码存入memcache：" + strCacheKey + " : " + nExpireTime + " : " + obj);
		}
		try {
			for (MemcachedClient cacheClient : this.alCacheClient) {
				Future<?> fb = cacheClient.set(strCacheKey, nExpireTime, obj);
				if (((Boolean) fb.get()).booleanValue())
					continue;
				bResult = false;
				if (logger.isDebugEnabled()) {
					logger.debug("faild to store memcache key:" + strCacheKey);
				}
			}

		} catch (Exception e) {
			bResult = false;
			if (e.getMessage().contains("object too large for cache")) {
				logger.warn("缓存数据对象过大!");
			}
			throw new RuntimeException(e);
		}

		return bResult;
	}

	public boolean putCacheValue(String strCacheKey, Object obj) {
		return putCacheValue(strCacheKey, obj, FOREVER);
	}

	public boolean putResponseToCache(String strCacheKey, CTO ctoResponse) {
		String strXML = ctoResponse.toXML();
		return putCacheValue(strCacheKey, strXML);
	}

	public boolean putResponseToCache(String strCacheKey, CTO ctoResponse, int nExpireTime) {
		String strXML = ctoResponse.toXML();
		return putCacheValue(strCacheKey, strXML, nExpireTime);
	}

	public Object getCacheValue(String strCacheKey) {
		if (strCacheKey == null) {
			return null;
		}

		Object objResult = null;
		for (MemcachedClient cacheClient : this.alCacheClient) {
			try {
				objResult = cacheClient.get(strCacheKey);
				break;
			} catch (Exception e) {
				if (logger.isDebugEnabled())
					;
				logger.debug(e);
			}
		}

		return objResult;
	}

	public boolean deleteCacheValue(String strCacheKey) {
		if (strCacheKey == null) {
			return false;
		}
		boolean bResult = true;
		for (MemcachedClient cacheClient : this.alCacheClient) {
			try {
				Future<?> fb = cacheClient.delete(strCacheKey);
				if (!((Boolean) fb.get()).booleanValue())
					;
				bResult = false;
				if (logger.isDebugEnabled()) {
					logger.debug("faild to delete memcache key:" + strCacheKey);
				}

			} catch (Exception e) {
				bResult = false;
				logger.warn(e);
				throw new RuntimeException(e);
			}
		}
		return bResult;
	}

	public Return initMemCach(MemCacheServerGroup group) {
		this.strId = group.getId();
		CacheServer[] cacheServers = group.getCacheServer();
		if ((cacheServers == null) || (cacheServers.length == 0)) {
			String strText = "Got wrong cacheserver define with id: " + this.strId;
			logger.error(strText);
			return Return.valueOf("-1", strText);
		}
		List<CTO> ctos = new ArrayList<CTO>();
		for (CacheServer cacheServer : cacheServers) {
			Server[] servers = cacheServer.getServer();
			if ((servers == null) || (servers.length == 0)) {
				String strText = "Wrong server conifg with id: " + this.strId;
				logger.error(strText);
				return Return.valueOf("-1", strText);
			}
			CTO cto = new CTO();
			cto.setObjectValue("id", cacheServer.getId());
			List<InetSocketAddress> lsinetSocketAddress = new ArrayList<InetSocketAddress>(servers.length);
			for (int i = 0; i < servers.length; ++i) {
				cto.setObjectValue("ip", servers[i].getIP());
				cto.setObjectValue("port", servers[i].getPort());
				lsinetSocketAddress.add(new InetSocketAddress(servers[i].getIP(), servers[i].getPort()));
			}
			try {
				MemcachedClient cacheClient = new MemcachedClient(lsinetSocketAddress);
				this.alCacheClient.add(cacheClient);
			} catch (IOException e) {
				logger.warn("Got wrong server conifg with id: " + this.strId, e);
			}
			ctos.add(cto);
		}
		if (logger.isInfoEnabled()) {
			logger.info("init cacheServer >>> " + ctos);
		}
		return Return.OK;
	}

	public Return init() {
		return Return.OK;
	}

	public void close() {
		try {
			for (MemcachedClient mc : this.alCacheClient) {
				mc.shutdown();
			}
		} catch (Exception e) {
			logger.warn(e);
		}
	}

	public boolean testConnection() {

		for (MemcachedClient mc : this.alCacheClient) {
			Future<?> fb = mc.set(strKey, FOREVER, strKey);
			try {
				if ((fb != null) && (((Boolean) fb.get()).equals(Boolean.TRUE))) {
					return true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return false;
	}

	public CacheClient() {
		this.alCacheClient = new ArrayList<MemcachedClient>(2);
	}

	public MemcachedNode getMemcachedNode(String strCacheKey) {
		if (strCacheKey == null) {
			return null;
		}

		MemcachedNode objResult = null;
		for (MemcachedClient cacheClient : this.alCacheClient) {
			try {
				objResult = cacheClient.getNodeLocator().getPrimary(strCacheKey);
				break;
			} catch (Exception e) {
				if (logger.isDebugEnabled()) {
					logger.debug(e);
				}
			}
		}

		return objResult;
	}
}