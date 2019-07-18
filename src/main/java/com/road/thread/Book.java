package com.road.thread;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/26 14:46
 **/
public class Book {
    public static void main(String[] args) {
        staticFunction();
    }
	static {
		System.out.println("书的静态代码块");
	}
    static Book book = new Book();



    {
		System.out.println("书的普通代码块");
	}

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",aount=" + amount);
    }

    public static void staticFunction() {
        System.out.println("书的方法");
    }

    int price = 110;
    static int amount = 112;
}
