package com.road.design.Mode.single;

/**
 * 单例模式：懒汉模式（线程不安全）、饿汉模式（线程安全）
 */
public class SinglePatternDemo {
	public static void main(String[] args) {

		// 不合法的构造函数
		// 编译时错误：构造函数 SingleObject()是不可见的
		// SingleObject singleObject = new SingleObject();

		// 获取唯一可用对象
		SingleObject singleObject = SingleObject.getInstance();

		// 显示信息
		singleObject.showMessage();
	}
}
