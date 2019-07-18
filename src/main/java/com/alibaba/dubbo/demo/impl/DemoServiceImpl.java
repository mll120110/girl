package com.alibaba.dubbo.demo.impl;

import com.alibaba.dubbo.demo.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author Road
 * @Date 2019/5/7 16:30
 **/
public class DemoServiceImpl implements DemoService {
    @Override
    public List<String> getPermissions(Long id) {
        ArrayList<String> demo = new ArrayList<>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}
