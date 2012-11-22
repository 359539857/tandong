package cto.framework.service;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cto.framework.core.json.JSONObject;

public class CycleMap<K, T> extends HashMap<K, T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6009841592289760199L;
	private ReentrantReadWriteLock lockList;

	public void addT(K id, T t) {
		this.lockList.writeLock().lock();
		try {
			this.put(id, t);
		} finally {
			this.lockList.writeLock().unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public T getT(K id) {
		this.lockList.readLock().lock();
		try {
			if (this.size() == 0) {
				return null;
			}
			Object localObject2 = this.get(id);
			return (T) localObject2;
		} finally {
			this.lockList.readLock().unlock();
		}
	}

	public void clear() {
		this.lockList.writeLock().lock();
		try {
			this.clear();
		} finally {
			this.lockList.writeLock().unlock();
		}
	}

	public int size() {
		this.lockList.readLock().lock();
		try {
			int i = this.size();
			return i;
		} finally {
			this.lockList.readLock().unlock();
		}
	}

	public CycleMap() {
		this.lockList = new ReentrantReadWriteLock();
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

}
