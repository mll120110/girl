package com.road.design.Mode.single;

/**
 * 单例饿汉模式
 */
public class SingletonNotLazy {
	private static SingletonNotLazy instance = new SingletonNotLazy();

	private SingletonNotLazy() {
	}

	public static SingletonNotLazy getInstance() {
		return instance;
	}
}
