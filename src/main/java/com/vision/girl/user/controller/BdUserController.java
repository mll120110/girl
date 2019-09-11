package com.vision.girl.user.controller;

import com.vision.girl.common.BaseController;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.entity.UserDeviceBean;
import com.vision.girl.user.service.IBdUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user/bd-user")
public class BdUserController extends BaseController {
    @Autowired
    IBdUserService userService;

    /**
     * 新增用户
     *
     * @param bdUser
     * @return
     */
    @PostMapping(value = "createUser")
    @ApiModelProperty(value = "创建用户信息")
    public int createUser(@RequestBody BdUser bdUser) {
        return userService.createUser(bdUser);
    }

    /**
     * 更新用户信息
     * 
     * @param bdUser
     * @return
     */
    @PostMapping(value = "updateUser")
    public int updateUser(BdUser bdUser) {
        return userService.updateUser(bdUser);
    }

    /**
     * 新增用户、用户与设备绑定关系数据
     *
     * @param userDeviceBean
     * @return
     */
    @PostMapping(value = "createUserAndDevice")
    @ApiOperation(value = "创建用户、用户与设备信息")
    public int createUserAndDevice(@RequestBody UserDeviceBean userDeviceBean) {
        return userService.createUserAndDevice(userDeviceBean);
    }

}
