package com.road.design.Mode.factory.abstractFactory;

public class ColorFactory extends AbstractFactory {
	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return null;
		} else if (color.equalsIgnoreCase("BLUE")) {
			return null;
		}
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
}
