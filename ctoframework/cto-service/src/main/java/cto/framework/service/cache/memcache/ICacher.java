/**
 * 
 */
package cto.framework.service.cache.memcache;

import net.spy.memcached.MemcachedNode;

/**
 * @author PeterTan
 * 
 */
public interface ICacher {
	public abstract boolean put(String paramString1, String paramString2, Object paramObject, int paramInt) throws Exception;

	public abstract boolean put(String paramString1, String paramString2, Object paramObject) throws Exception;

	public abstract boolean delete(String paramString1, String paramString2) throws Exception;

	public abstract Object get(String paramString1, String paramString2) throws Exception;

	public abstract MemcachedNode getMemcachedNode(String paramString1, String paramString2);

	public abstract void close();

	public abstract boolean testConnection(String paramString);
}
