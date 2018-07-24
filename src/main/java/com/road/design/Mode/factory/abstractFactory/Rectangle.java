package com.road.design.Mode.factory.abstractFactory;

/**
 * 矩形实现图形接口
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
