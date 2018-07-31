package com.road.design.Mode.builder;

/**
 * 包装实现packing接口，重写方法
 */
public class Wrapper implements Packing {
	@Override
	public String pack() {
		return "Wrapper";
	}
}
