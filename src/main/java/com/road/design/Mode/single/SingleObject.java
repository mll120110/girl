package com.road.design.Mode.single;

/**
 * 单例饿汉模式（类加载时初始化，浪费内存）
 */
public class SingleObject {
	// create singleObject 对象
	private static SingleObject singleObject = new SingleObject();

	// 构造函数private,该类不会被实例化
	private SingleObject() {
	}

	// 获取唯一可用对象
	public static SingleObject getInstance() {
		return singleObject;
	}

	public void showMessage() {
		System.out.println("Hello World");
	}
}
