package org.service.app.util;

import java.util.Map;

/**
 * This will class allows method to be used for storing Thread level variables.
 * 
 * @author Anish
 *
 */

public class AppThreadLocal {

	private static AppThreadLocal appThreadLocal;

	private ThreadLocal<Map<Object, Object>> threadLocal;

	{
		threadLocal = new ThreadLocal<Map<Object, Object>>();
	}

	private AppThreadLocal() {
		if (appThreadLocal != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	public static AppThreadLocal getAppThreadLocal() {
		if (appThreadLocal == null) {
			appThreadLocal = new AppThreadLocal();
		}
		return appThreadLocal;
	}

	public Map<Object, Object> getThreadMap() {
		return (Map<Object, Object>) appThreadLocal.threadLocal.get();
	}

	public Object getObject(Object key) {
		return ((Map<Object, Object>) appThreadLocal.threadLocal.get()).get(key);
	}

	public void put(Object key, Object value) {
		((Map<Object, Object>) appThreadLocal.threadLocal.get()).put(key, value);
	}

	public void remove(Object key) {
		((Map<Object, Object>) appThreadLocal.threadLocal.get()).remove(key);
	}

	public void removeAll() {
		((Map<Object, Object>) appThreadLocal.threadLocal.get()).clear();
	}
}
