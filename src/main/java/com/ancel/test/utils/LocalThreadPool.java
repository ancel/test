package com.ancel.test.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum LocalThreadPool {
	
	Cached,//不定数量的线程池
	Fixed,//固定数量线程池
	Scheduled,//定时线程池
	Single;//单个线程
	
	
	private int nThreads = 5;
	public ExecutorService getThreadPool(){
		switch (this) {
		case Cached:
			return Executors.newCachedThreadPool();
		case Fixed:
			return Executors.newFixedThreadPool(nThreads);
		case Scheduled:
			return Executors.newScheduledThreadPool(nThreads);
		case Single:
			return Executors.newSingleThreadExecutor();
		default:
			return Executors.newCachedThreadPool(); 
		}
	}
	
	public int getnThreads() {
		return nThreads;
	}
	public void setnThreads(int nThreads) {
		this.nThreads = nThreads;
	}

	
}
