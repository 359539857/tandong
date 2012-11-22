/**
 * 
 */
package cto.framework.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author PeterTan
 * 
 */
public class ApplicationContext {

	private static Map<Object, Object> contextMap = new HashMap<Object, Object>(6);

	public static void put(Object key, Object value) {
		contextMap.put(key, value);
	}

	public static Object get(Object key) {
		return contextMap.get(key);
	}

	public static void remove(Object key) {
		contextMap.remove(key);
	}

	public static int size() {
		return contextMap.size();
	}

	public static Set<Object> keySet() {
		return contextMap.keySet();
	}

}
