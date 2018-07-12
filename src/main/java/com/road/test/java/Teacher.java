package com.road.test.java;

public class Teacher extends Person {
	private String name = "Tom";

	// 构造方法
	public Teacher() {
		super();
		System.out.println("this is teacher");
	}

	public static void main(String[] args) {
		int i = 12;
		System.out.println(i += i -= i *= i);
	}
}
