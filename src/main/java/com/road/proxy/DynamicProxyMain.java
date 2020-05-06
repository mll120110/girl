package com.road.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Describe
 * @Author Road
 * @Date 2019/4/23 11:29
 **/
public class DynamicProxyMain {
    public static void consumer(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name: " + name);
    }

    public static void main(String[] args) {
        // new一个新的对象
        RealObject realObject = new RealObject();
        // 调用consumer方法
        consumer(realObject);
        System.out.println("==============================");

        // ========动态代理=========
        // 获取类加载器
        ClassLoader classLoader = Interface.class.getClassLoader();
        // 代理类要实现的接口
        Class<?>[] interfaces = new Class[] {Interface.class};
        // 调用处理对象
        InvocationHandler handler = new DynamicProxyHandler(realObject);
        // java中反射包，返回Object，强制转换为Interface
        Interface proxy = (Interface)Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println("in dynamicProxyMain proxy:" + proxy.getClass());
        consumer(proxy);

        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] {Interface.class});
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(name + ".class");
            System.out.println((new File("hello")).getAbsolutePath());
            outputStream.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
