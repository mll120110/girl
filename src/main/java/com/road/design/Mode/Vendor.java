package com.road.design.Mode;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/18 16:29
 **/
public class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("In sell method");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}
