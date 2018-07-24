package com.road.design.Mode.factory.simpleFactory;

public class DellMouse extends Mouse{
	@Override
	public void sayHi() {
		System.out.println("DellMouse制造");
		super.sayHi();
	}
}
