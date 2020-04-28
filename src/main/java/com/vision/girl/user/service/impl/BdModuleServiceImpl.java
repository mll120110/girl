package com.vision.girl.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vision.girl.user.entity.BdModule;
import com.vision.girl.user.mapper.BdModuleMapper;
import com.vision.girl.user.service.IBdModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 功能模块表 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Slf4j
@Service(value = "bdModuleServiceImpl")
public class BdModuleServiceImpl extends ServiceImpl<BdModuleMapper, BdModule> implements IBdModuleService {

    @Autowired
    BdModuleMapper bdModuleMapper;

    @Override
    public int createModule(BdModule bdModule) {
        bdModule.setState(1);
        bdModule.setCreateTime(LocalDateTime.now());
        bdModule.setUpdateTime(LocalDateTime.now());
        return bdModuleMapper.insert(bdModule);
    }

    @Override
    public BdModule getModule(Long moduleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("module_id", moduleId);
        queryWrapper.eq("state", 1);
        return bdModuleMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<BdModule> getModuleList(int startPage, int endPage) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Page<BdModule> modulePage = new Page<>(startPage, endPage);
        queryWrapper.eq("state", 1);
        log.info("selectPage" + bdModuleMapper.selectPage(modulePage, queryWrapper).toString());
        return bdModuleMapper.selectPage(modulePage, queryWrapper);
    }

    @Override
    public int updateModule(BdModule bdModule, Long moduleId) {
        UpdateWrapper<BdModule> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("module_id", (moduleId != 0L) ? moduleId : bdModule.getModuleId());
        return bdModuleMapper.update(bdModule, updateWrapper);
    }

    @Override
    public int deleteModule(Long moduleId) {
        int result = 0;
        UpdateWrapper<BdModule> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("module_id", moduleId);
        BdModule bdModule = this.getModule(moduleId);
        if (bdModule != null) {
            // 无效
            bdModule.setState(0);
            result = bdModuleMapper.update(bdModule, updateWrapper);
        }
        return result;
    }
}
