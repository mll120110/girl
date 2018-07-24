package com.road.design.Mode.factory.simpleFactory;

/**
 * 简单工厂模式简单实例（简单工厂模式不是23中设计模式一种，只是一种实现方式）
 */
public class SimpleFactoryDemo {
	public static void main(String[] args) {
		Mouse mouse = MouseFactory.createMouse(1);
	}
}
