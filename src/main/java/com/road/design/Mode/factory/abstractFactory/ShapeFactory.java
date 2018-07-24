package com.road.design.Mode.factory.abstractFactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase(""))
			return null;
		if (shapeType.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		if (shapeType.equalsIgnoreCase(""))
			return null;
		return null;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}
}
