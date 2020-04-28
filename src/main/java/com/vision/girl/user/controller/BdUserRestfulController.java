package com.vision.girl.user.controller;

import com.vision.girl.common.BaseController;
import com.vision.girl.common.ResultBean;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.service.IBdUserService;
import com.vision.girl.user.service.impl.BdUserServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 使用Resultful接口风格实现web接口
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-28
 */
@Slf4j
@RestController
@RequestMapping("/user/bd-user/restful")
public class BdUserRestfulController extends BaseController {

    /**
     * 修改@Autowired注入方式，为构造器注入方式
     */
    private final IBdUserService userService;

    @Autowired
    public BdUserRestfulController(BdUserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 新增用户，使用Mybatis-plus自带组件新增一条记录
     *
     * @param bdUser
     * @return
     */
    @PostMapping(value = "user")
    @ApiOperation(value = "创建用户信息")
    public ResultBean createUser(@Valid @RequestBody BdUser bdUser) {
        userService.createUser(bdUser);
        return ResultBean.success();
    }

    /**
     * 分页获取userList
     *
     * @param startPage
     * @param endPage
     * @return
     */
    @GetMapping(value = "user")
    public ResultBean getUserList(@RequestParam int startPage, @RequestParam int endPage) {
        return ResultBean.success(userService.getUserList(startPage, endPage));
    }

    /**
     * 获取用户信息，使用Mybatis-plus组件有条件的查询一条记录
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "user/{userId}")
    @ApiOperation(value = "获取用户信息")
    public ResultBean getUser(@PathVariable String userId) {
        return ResultBean.success(userService.getUser(userId));
    }

    /**
     * 更新用户信息，put方式，body需要传递对象的所有字段
     *
     * @param bdUser
     * @param userId
     * @return
     */
    @PutMapping(value = "user/{userId}")
    @ApiOperation(value = "更新用户所有字段信息")
    public ResultBean updateUser(@Valid @RequestBody BdUser bdUser, @PathVariable Long userId) {
        userService.updateUser(bdUser, userId);
        return ResultBean.success();
    }

    /**
     * 更新用户信息，patch方式，body需要传递对象的部分字段
     *
     * @param bdUser
     * @param userId
     * @return
     */
    @PatchMapping(value = "user/{userId}")
    @ApiModelProperty(value = "更新用户部分字段信息")
    public ResultBean pathUser(@RequestBody BdUser bdUser, @PathVariable Long userId) {
        userService.updateUser(bdUser, userId);
        return ResultBean.success("更新用户部分字段信息");
    }

    /**
     * 删除用户信息，delete方式
     *
     * @param userId
     * @return
     */
    @DeleteMapping(value = "user/{userId}")
    @ApiModelProperty(value = "删除用户信息")
    public ResultBean DeleteUser(@PathVariable Long userId) {
        return ResultBean.success();
    }
}
