package com.road.design.Mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/18 16:30
 **/
public class DynamicProxy implements InvocationHandler {
    private Object obj;

    public DynamicProxy(Object object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }
}
