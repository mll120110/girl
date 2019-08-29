package com.vision.girl.user.controller;

import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.service.IBdUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.girl.common.BaseController;

import java.time.LocalDateTime;
import java.util.UUID;

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

    @PostMapping(value = "createUser")
    public int createUser() {
        BdUser bdUser = new BdUser();
        bdUser.setUserId(UUID.randomUUID().toString());
        bdUser.setUserName("Jack Road");
        bdUser.setState(0);
        bdUser.setUpdateTime(LocalDateTime.now());
        bdUser.setCreateTime(LocalDateTime.now());
        return userService.createUser(bdUser);
    }

    @PostMapping(value = "updateUser")
    public int updateUser(BdUser bdUser) {
        return userService.updateUser(bdUser);
    }
}
