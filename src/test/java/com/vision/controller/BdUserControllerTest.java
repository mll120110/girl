package com.vision.controller;

import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.entity.UserDeviceBean;
import com.vision.girl.user.service.IBdUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Jack_Road
 * @date 2019/8/29 14:30
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BdUserControllerTest {
    @Autowired
    IBdUserService iBdUserService;

    // 实例化user信息
    BdUser bdUser;

    // 实例化device信息
    BdDevice bdDevice;

    public BdUserControllerTest() {
        // 实例化user信息
        bdUser = new BdUser();
        bdUser.setUserId(UUID.randomUUID().toString());
        bdUser.setUserName("Jack Road");
        // 状态0无效，1有效
        bdUser.setState(1);
        bdUser.setCreateTime(LocalDateTime.now());
        bdUser.setUpdateTime(LocalDateTime.now());

        // 实例化device信息
        bdDevice = new BdDevice();
        bdDevice.setDeviceId(UUID.randomUUID().toString());
        bdDevice.setDeviceName("TestNewDeviceName");
        bdDevice.setDeviceNumber(1L);
        // 状态0无效，1有效
        bdDevice.setState(1);
        bdUser.setCreateTime(LocalDateTime.now());
        bdUser.setUpdateTime(LocalDateTime.now());
    }

    @Test
    public void createUser() {
        iBdUserService.createUser(bdUser);
    }

    @Test
    public void updateUser() {
        bdUser.setUpdateTime(LocalDateTime.now());
        iBdUserService.updateUser(bdUser);
    }

    @Test
    public void createUserAndDevice() {
        UserDeviceBean userDeviceBean = new UserDeviceBean();
        userDeviceBean.setBdUser(bdUser);
        userDeviceBean.setBdDevice(bdDevice);
        // 状态0无效，1有效
        userDeviceBean.setState(1);
        iBdUserService.createUserAndDevice(userDeviceBean);
    }
}
