package com.road.proxy;

/**
 * @Describe 真实对象
 * @Author Road
 * @Date 2019/4/23 11:13
 **/
public class RealObject implements Interface {

    @Override
    public void getMyName() {
        System.out.println("my name is RealObject.getMyName");
    }

    @Override
    public String getNameById(String id) {
        System.out.println("RealObject.getNameById argument id " + id);
        return "xxx";
    }
}
