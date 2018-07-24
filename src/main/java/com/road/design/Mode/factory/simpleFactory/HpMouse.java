package com.road.design.Mode.factory.simpleFactory;

public class HpMouse extends Mouse{
	@Override
	public void sayHi() {
		System.out.println("HpMouse制造");
		super.sayHi();
	}
}
