package com.road.lambda;

/**
 * Lambdda表达式，函数式接口，接口中只有一个方法；
 * 
 * 可以存在default定义的方法，可存在static的静态方法，可实现Object的方法
 */
@FunctionalInterface
public interface LambdaInterface {

    /**
     * 函数式接口的唯一方法
     * 
     * @param name
     * @return
     */
    String messageCheck(String name);

    /**
     * 重写Object的方法
     *
     * @param obj
     * @return
     */
    boolean equals(Object obj);

    /**
     * default定义的方法
     * 
     * @param name
     * @return
     */
    default String messageConsole(String name) {
        return name;
    }

    /**
     * static的静态方法
     * 
     * @param name
     * @return
     */
    static String messageStatic(String name) {
        return name;
    }
}
