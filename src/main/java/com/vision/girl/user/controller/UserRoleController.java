package com.vision.girl.user.controller;

import com.vision.girl.common.BaseController;
import com.vision.girl.common.ResultBean;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.service.UserRoleService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user/user-role/")
public class UserRoleController extends BaseController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(@Qualifier(value = "userRoleServiceImpl") UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    /**
     * 用户绑定的角色
     * 
     * @param userId
     * @param bdRoleList
     * @return
     */
    @PostMapping(value = "role/{userId}")
    @ApiOperation(value = "用户新增绑定的角色")
    public ResultBean createUserRole(@PathVariable Long userId, @Valid @RequestBody List<BdRole> bdRoleList) {
        userRoleService.createUserRole(userId, bdRoleList);
        return ResultBean.success();
    }

    /**
     * 单用户移除角色列表
     * 
     * @param userId
     * @param bdRoleList
     * @return
     */
    @DeleteMapping(value = "role/{userId}")
    @ApiModelProperty(value = "单用户移除角色列表")
    public ResultBean removeUserRole(@PathVariable Long userId, @Valid @RequestBody List<BdRole> bdRoleList) {
        userRoleService.removeUserRole(userId, bdRoleList);
        return ResultBean.success();
    }

    /**
     * 单用户更新角色列表
     * 
     * @param userId
     * @param bdRoleList
     * @return
     */
    @PutMapping(value = "role/{userId}")
    @ApiModelProperty(value = "单用户更新角色列表")
    public ResultBean updateUserRole(@PathVariable Long userId, @Valid @RequestBody List<BdRole> bdRoleList) {
        userRoleService.updateUserRole(userId, bdRoleList);
        return ResultBean.success();
    }

    /**
     * 单用户所有角色列表
     * 
     * @param userId
     * @return
     */
    @GetMapping(value = "role/{userId}")
    @ApiModelProperty(value = "单用户所有角色列表")
    public ResultBean selectUserRole(@PathVariable Long userId) {
        return ResultBean.success(userRoleService.getRoleListByUserId(userId));
    }
}
