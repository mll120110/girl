package com.road.design.Mode.factory.factoryMode;

public class ShapeFactory {
	//使用getShape方法获取形状类型对象
	public Shape getShape(String shapeType){
		if (shapeType == null){
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if (shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}
		return null;
	}
}
