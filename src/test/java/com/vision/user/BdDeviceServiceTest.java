package com.vision.user;

import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.service.IBdDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BdDeviceServiceTest {

    @Autowired
    IBdDeviceService deviceService;

    @Test
    public void createDevice() throws Exception {
        BdDevice bdDevice = new BdDevice();
        bdDevice.setDeviceId(UUID.randomUUID().toString());
        bdDevice.setDeviceName("TestNewDevice");
        bdDevice.setDeviceNumber(1000008376L);
        // 状态0：无效，1：有效
        bdDevice.setState(1);
        bdDevice.setCreateTime(LocalDateTime.now());
        bdDevice.setUpdateTime(LocalDateTime.now());
        deviceService.createDevice(bdDevice);
    }
}
