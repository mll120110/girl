package com.vision.girl.user.controller;


import com.vision.girl.common.BaseController;
import com.vision.girl.common.ResultBean;
import com.vision.girl.user.entity.BdModule;
import com.vision.girl.user.service.IBdModuleService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 功能模块表 前端控制器
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/user/bd-module")
public class BdModuleController extends BaseController {

    @Autowired
    @Qualifier(value = "bdModuleServiceImpl")
    IBdModuleService bdModuleServiceImpl;
    /**
     * 新增模块
     *
     * @param bdModule 模块对象
     * @return ResultBean
     */
    @PostMapping(value = "module")
    @ApiModelProperty(value = "新增模块")
    public ResultBean createModule(@Valid @RequestBody BdModule bdModule) {
        bdModuleServiceImpl.createModule(bdModule);
        return ResultBean.success();
    }

    /**
     * 根据id获取模块信息
     *
     * @param moduleId 模块id
     * @return ResultBean
     */
    @GetMapping(value = "module/{moduleId}")
    @ApiModelProperty(value = "根据id获取模块信息")
    public ResultBean getModule(@PathVariable Long moduleId) {
        return ResultBean.success(bdModuleServiceImpl.getModule(moduleId));
    }

    /**
     * 获取模块list集合
     *
     * @param startPage 模块对象
     * @param endPage 模块id
     * @return ResultBean
     */
    @GetMapping(value = "module")
    @ApiModelProperty(value = "获取模块list集合")
    public ResultBean getModuleList(@RequestParam int startPage, @RequestParam int endPage) {
        return ResultBean.success(bdModuleServiceImpl.getModuleList(startPage, endPage));
    }

    /**
     * 全量更新模块信息
     *
     * @param bdModule 模块对象
     * @param moduleId 模块id
     * @return ResultBean
     */
    @PutMapping(value = "module/{moduleId}")
    @ApiModelProperty(value = "全量更新模块信息")
    public ResultBean updateModule(@Valid @RequestBody BdModule bdModule, @PathVariable Long moduleId) {
        bdModuleServiceImpl.updateModule(bdModule, moduleId);
        return ResultBean.success();
    }

    /**
     * 部分更新模块信息
     *
     * @param bdModule 模块对象
     * @param moduleId 模块id
     * @return ResultBean
     */
    @PatchMapping(value = "module/{moduleId}")
    @ApiModelProperty(value = "部分更新模块信息")
    public ResultBean patchModule(@RequestBody BdModule bdModule, @PathVariable Long moduleId) {
        bdModuleServiceImpl.updateModule(bdModule, moduleId);
        return ResultBean.success();
    }

    /**
     * 删除模块信息
     *
     * @param moduleId 模块id
     * @return ResultBean
     */
    @DeleteMapping(value = "module/{moduleId}")
    @ApiModelProperty(value = "删除模块信息")
    public ResultBean deletehModule(@PathVariable Long moduleId) {
        bdModuleServiceImpl.deleteModule(moduleId);
        return ResultBean.success();
    }
}
