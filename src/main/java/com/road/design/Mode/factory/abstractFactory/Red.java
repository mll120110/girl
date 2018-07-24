package com.road.design.Mode.factory.abstractFactory;

public class Red implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}
