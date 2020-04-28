package com.vision.girl.user.controller;

import com.vision.girl.common.ResultBean;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.service.IBdRoleService;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.vision.girl.common.BaseController;

import javax.validation.Valid;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Slf4j
@RestController
@RequestMapping("/role/bd-role")
public class BdRoleController extends BaseController {

    @Autowired
    @Qualifier(value = "bdRoleServiceImpl")
    IBdRoleService bdRoleServiceImpl;

    /**
     * 新增角色
     * 
     * @param bdRole
     * @return
     */
    @PostMapping(value = "role")
    @ApiModelProperty(value = "新增角色")
    public ResultBean createRole(@Valid @RequestBody BdRole bdRole) {
        bdRoleServiceImpl.createRole(bdRole);
        return ResultBean.success();
    }

    /**
     * 根据id获取角色信息
     * 
     * @param rodeId
     * @return
     */
    @GetMapping(value = "role/{rodeId}")
    @ApiModelProperty(value = "根据id获取角色信息")
    public ResultBean getRole(@PathVariable Long rodeId) {
        return ResultBean.success(bdRoleServiceImpl.getRole(rodeId));
    }

    /**
     * 获取角色list集合
     * 
     * @param startPage
     * @param endPage
     * @return
     */
    @GetMapping(value = "role")
    @ApiModelProperty(value = "获取角色list集合")
    public ResultBean getRoleList(@RequestParam int startPage, @RequestParam int endPage) {
        return ResultBean.success(bdRoleServiceImpl.getRoleList(startPage, endPage));
    }

    /**
     * 全量更新角色信息
     * 
     * @param bdRole
     * @param rodeId
     * @return
     */
    @PutMapping(value = "role/{rodeId}")
    @ApiModelProperty(value = "全量更新角色信息")
    public ResultBean updateRole(@Valid @RequestBody BdRole bdRole, @PathVariable Long rodeId) {
        bdRoleServiceImpl.updateRole(bdRole, rodeId);
        return ResultBean.success();
    }

    /**
     * 部分更新角色信息
     * 
     * @param bdRole
     * @param rodeId
     * @return
     */
    @PatchMapping(value = "role/{rodeId}")
    @ApiModelProperty(value = "部分更新角色信息")
    public ResultBean patchRole(@RequestBody BdRole bdRole, @PathVariable Long rodeId) {
        bdRoleServiceImpl.updateRole(bdRole, rodeId);
        return ResultBean.success();
    }

    /**
     * 删除角色信息
     * 
     * @param rodeId
     * @return
     */
    @DeleteMapping(value = "role/{rodeId}")
    @ApiModelProperty(value = "删除角色信息")
    public ResultBean deletehRole(@PathVariable Long rodeId) {
        bdRoleServiceImpl.deleteRole(rodeId);
        return ResultBean.success();
    }
}
