package com.road.design.Mode.factory.simpleFactory;

public class MouseFactory {
	public static Mouse createMouse(int choice) {
		System.out.println("输入数字 " + choice);
		switch (choice) {
		case 0:
			new DellMouse().sayHi();
			break;
		case 1:
			new HpMouse().sayHi();
			break;
		default:
			System.out.println("Not Type");
		}
		return null;
	}
}
