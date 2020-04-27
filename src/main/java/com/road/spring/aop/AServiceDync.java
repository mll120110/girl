package com.road.spring.aop;

public class AServiceDync implements ServiceDync {
    @Override
    public void add() {
        System.out.println("==============add data");
    }

    @Override
    public void update() {
        System.out.println("==============update data");
    }
}
