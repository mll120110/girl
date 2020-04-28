package com.vision.girl.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vision.girl.user.entity.BdModule;

/**
 * <p>
 * 功能模块表 服务类
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
public interface IBdModuleService extends IService<BdModule> {
    int createModule(BdModule bdModule);

    BdModule getModule(Long moduleId);

    IPage<BdModule> getModuleList(int startPage, int endPage);

    int updateModule(BdModule bdModule, Long moduleId);

    int deleteModule(Long moduleId);
}
