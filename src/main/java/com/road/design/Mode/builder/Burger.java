package com.road.design.Mode.builder;

/**
 * 抽象类，不完全实现接口中的所有方法
 */
public abstract class Burger implements Item {
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
