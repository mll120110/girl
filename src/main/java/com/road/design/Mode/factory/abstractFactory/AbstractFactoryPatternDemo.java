package com.road.design.Mode.factory.abstractFactory;

/**
 * 抽象工厂模式（属于工厂模式的集合管理）
 */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		// 获取形状工厂
		AbstractFactory abstractFactory = FactoryProducer.getFactory("SHAPE");
		// 获取形状Rectangle对象
		Shape shape1 = abstractFactory.getShape("RECTANGLE");
		shape1.draw();

		// 获取颜色工厂
		AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
		// 获取red对象
		Color color = colorFactory.getColor("RED");
		color.fill();
	}
}
