package com.road.proxy;

/**
 * @Describe
 * @Author Road
 * @Date 2019/4/23 11:16
 **/
public class SimpleProxy implements Interface {
    private Interface anInterface;

    public SimpleProxy(Interface anInterface) {
        this.anInterface = anInterface;
    }

    @Override
    public void getMyName() {
        System.out.println("proxy getMyName");
        anInterface.getMyName();
    }

    @Override
    public String getNameById(String id) {
        System.out.println("proxy getNameId");
        return anInterface.getNameById(id);
    }
}
