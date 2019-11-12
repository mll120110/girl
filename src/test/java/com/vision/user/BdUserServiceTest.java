package com.vision.user;

import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.entity.UserDeviceBean;
import com.vision.girl.user.service.IBdUserService;
import com.vision.girl.user.vo.UserDeviceVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Jack_Road
 * @date 2019/8/29 14:30
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
/**
 * 带事务注解单元测试不增加冗余数据
 */
@Transactional
public class BdUserServiceTest {
    @Autowired
    IBdUserService iBdUserService;

    // 实例化user信息
    BdUser bdUser;

    // 实例化device信息
    BdDevice bdDevice;

    public BdUserServiceTest() {
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
    public void createUser() throws Exception {
        iBdUserService.createUser(bdUser);
    }

    @Test
    public void updateUser() throws Exception {
        bdUser.setUpdateTime(LocalDateTime.now());
        iBdUserService.updateUser(bdUser);
    }

    @Test
    public void createUserAndDevice() throws Exception {
        UserDeviceBean userDeviceBean = new UserDeviceBean();
        userDeviceBean.setBdUser(bdUser);
        userDeviceBean.setBdDevice(bdDevice);
        // 状态0无效，1有效
        userDeviceBean.setState(1);
        iBdUserService.createUserAndDevice(userDeviceBean);
    }

    @Test
    public void getUser() throws Exception {
        iBdUserService.getUser("7ef4b34c-4bea-4dd3-b367-e3da33fc6bb6");
    }

    @Test
    public void getUserList() throws Exception {
        iBdUserService.getUserList(0, 10);
    }

    @Test
    public void getUserBeanList() throws Exception {
        List<UserDeviceVO> userBeanList = iBdUserService.getUserBeanList("e7ee86ca-23f3-478c-9d38-3d2a1083c236");
        Assert.assertNotNull(userBeanList);
        for (UserDeviceVO userDeviceVO : userBeanList) {
            log.debug(userDeviceVO.toString());
        }
    }
}
