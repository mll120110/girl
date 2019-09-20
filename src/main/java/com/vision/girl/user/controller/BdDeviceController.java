package com.vision.girl.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.girl.common.BaseController;
import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.service.IBdDeviceService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Slf4j
@RestController
@RequestMapping("/user/bd-device")
public class BdDeviceController extends BaseController {

    @Autowired
    @Qualifier("bdDeviceServiceImpl")
    IBdDeviceService deviceService;

    /**
     * 创建设备信息
     * 
     * @param bdDevice
     * @return
     */
    @PostMapping(value = "createDevice")
    @ApiOperation(value = "创建设备信息")
    public int createDevice(@RequestBody BdDevice bdDevice) {
        return deviceService.createDevice(bdDevice);
    }
}
