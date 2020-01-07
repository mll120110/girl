package com.road.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectTest {
    public static void main(String[] args) {
        // 1、获取并输出类的名称
        Class mClass = ChildClass.class;
        System.out.println("类名称" + mClass.getName());

        // 2、获取所有public 访问权限的变量
        Field[] fields = mClass.getFields();
        // 遍历变量并输出变量信息
        for (Field field : fields) {
            // 获取访问权限
            int modifiers = field.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers) + " ");
            // 输出变量的类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());
        }

        // 3、获取所有本类声明的变量
        Field[] allField = mClass.getDeclaredFields();
        for (Field field : allField) {
            int modifiers = field.getModifiers();
            System.out.println(Modifier.toString(modifiers) + " ");
            System.out.println(field.getType().getName() + " " + field.getName());
        }

        // 4、获取所有方法，定义方法时的参数可以获取到，方法内部的局部变量不能获取
        Method[] methods = mClass.getMethods();
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("parameter" + parameter.getName());
            }
        }
    }
}
