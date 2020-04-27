package com.road.spring.aop;

import java.lang.reflect.Proxy;

public class TestDync {
    public static void main(String[] args) {
        ServiceDync aserviceDync = new AServiceDync();
        MyInvocationHandler handler = new MyInvocationHandler(aserviceDync);
        ServiceDync aServiceProxy = (ServiceDync)Proxy.newProxyInstance(aserviceDync.getClass().getClassLoader(),
            aserviceDync.getClass().getInterfaces(), handler);
        // 由动态生成的代理对象来aServiceProxy 代理执行程序，其中aServiceProxy 符合Service接口
        aServiceProxy.add();
        System.out.println();
        aServiceProxy.update();
    }
}
