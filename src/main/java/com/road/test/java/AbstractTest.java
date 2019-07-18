package com.road.test.java;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/28 11:04
 **/
public abstract class AbstractTest {
	private int i;

	public AbstractTest() {
	}

	public abstract  void testA();


    public void conTestB() {
		testA();
	}
}
