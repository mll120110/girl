package com.vision.girl.user.controller;

import com.vision.girl.common.BaseController;
import com.vision.girl.common.ResultBean;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.entity.UserDeviceBean;
import com.vision.girl.user.service.IBdUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("bdUserServiceImpl")
    IBdUserService userService;

    /**
     * 新增用户，使用Mybatis-plus自带组件新增一条记录
     *
     * @param bdUser
     * @return
     */
    @PostMapping(value = "createUser")
    @ApiModelProperty(value = "创建用户信息")
    public ResultBean createUser(@RequestBody BdUser bdUser) {
        userService.createUser(bdUser);
        return ResultBean.success();
    }

    /**
     * 更新用户信息，用Mybatis-plus自带组件Update一条记录
     * 
     * @param bdUser
     * @return
     */
    @PostMapping(value = "updateUser")
    public ResultBean updateUser(BdUser bdUser) {
        userService.updateUser(bdUser);
        return ResultBean.success();
    }

    /**
     * 新增用户、用户与设备绑定关系数据（单条用户、单条设备关系），使用Spring事务注解完成多表数据操作
     *
     * @param userDeviceBean
     * @return
     */
    @PostMapping(value = "createUserAndDevice")
    @ApiOperation(value = "创建用户、用户与设备信息")
    public ResultBean createUserAndDevice(@RequestBody UserDeviceBean userDeviceBean) {
        userService.createUserAndDevice(userDeviceBean);
        return ResultBean.success();
    }

    /**
     * 新增用户、用户与设备绑定关系数据（单条用户、多个设备关系），使用Spring事务注解完成多表数据操作
     * 
     * @param userDeviceBean
     * @return
     */
    @PostMapping(value = "createUserAndDevicesList")
    @ApiModelProperty(value = "创建单用户与多设备信息")
    public ResultBean createUserAndDevicesList(@RequestBody UserDeviceBean userDeviceBean) {
        return ResultBean.success();
    }

    /**
     * 获取用户信息，使用Mybatis-plus组件有条件的查询一条记录
     * 
     * @param userId
     * @return
     */
    @GetMapping(value = "getUser")
    @ApiModelProperty(value = "获取用户信息")
    public ResultBean getUser(@RequestParam String userId) {
        return ResultBean.success(userService.getUser(userId));
    }

    /**
     * 分页获取用户列表信息，使用Mybatis-plus组件使用分页
     * 
     * @param startPage
     * @param endPage
     * @return
     */
    @GetMapping(value = "getUserList")
    @ApiModelProperty(value = "获取用户信息列表")
    public ResultBean getUserList(@RequestParam int startPage, @RequestParam int endPage) {
        return ResultBean.success(userService.getUserList(startPage, endPage));
    }

    /**
     * 获取一条用户信息，使用@Select注解写SQL获取信息
     * 
     * @return
     */
    @GetMapping(value = "getUserInfo")
    @ApiModelProperty(value = "获取一条用户信息")
    public ResultBean getUserInfo() {
        return ResultBean.success(userService.getUserInfo());
    }

    /**
     * 获取二条用户信息,使用XML配置方式编写SQL获取信息
     * 
     * @return
     */
    @GetMapping(value = "getUserInfoTwo")
    @ApiModelProperty(value = "获取二条用户信息")
    public ResultBean getUserInfoTwo() {
        return ResultBean.success(userService.getUserInfoTwo());
    }

    /**
     * 根据关联关系获取用户与设备的信息，一个用户绑定多个设备的场景进行逻辑编写获取查询信息
     * 
     * @return
     */
    @GetMapping(value = "getUserBeanList")
    @ApiModelProperty(value = "根据关联关系获取用户与设备的信息")
    public ResultBean getUserBeanList(String userId) {
        return ResultBean.success(userService.getUserBeanList(userId));
    }
}