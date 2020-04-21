package com.road.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Describe
 * @Author Road
 * @Date 2019/5/7 16:53
 **/
public class ProviderServiceTest {

    public static void main(String[] args) {
        boolean is = true;
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"applicationProvider.xml"});
        context.start();
        System.out.println("Provider service registry success");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
