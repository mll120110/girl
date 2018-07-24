package com.road.design.Mode.factory.factoryMode;

/**
 * 工厂模式
 */
public class FactoryDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		// 调用circle对象，并调用draw方法
		Shape shape = shapeFactory.getShape("CIRCLE");
		shape.draw();
		// 调用rectangle对象，并调用draw方法
		Shape shape1 = shapeFactory.getShape("RECTANGLE");
		shape1.draw();
	}
}
