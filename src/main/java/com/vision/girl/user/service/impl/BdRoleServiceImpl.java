package com.vision.girl.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.mapper.BdRoleMapper;
import com.vision.girl.user.service.IBdRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Service(value = "bdRoleServiceImpl")
public class BdRoleServiceImpl extends ServiceImpl<BdRoleMapper, BdRole> implements IBdRoleService {

    @Autowired
    BdRoleMapper bdRoleMapper;

    /**
     * 新增角色
     *
     * @param bdRole
     * @return
     */
    @Override
    public int createRole(BdRole bdRole) {
        bdRole.setState(1);
        bdRole.setCreateTime(LocalDateTime.now());
        bdRole.setUpdateTime(LocalDateTime.now());
        return bdRoleMapper.insert(bdRole);
    }

    /**
     * 根据id获取角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public BdRole getRole(Long roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        queryWrapper.eq("state", 1);
        return bdRoleMapper.selectOne(queryWrapper);
    }

    /**
     * 获取角色list集合
     *
     * @param startPage
     * @param endPage
     * @return
     */
    @Override
    public IPage<BdRole> getRoleList(int startPage, int endPage) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Page<BdRole> rolePage = new Page<>(startPage, endPage);
        queryWrapper.eq("state", 1);
        return bdRoleMapper.selectPage(rolePage, queryWrapper);
    }

    /**
     * 更新角色信息
     *
     * @param bdRole
     * @param roleId
     * @return
     */
    @Override
    public int updateRole(BdRole bdRole, Long roleId) {
        UpdateWrapper<BdRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", (roleId != 0L) ? roleId : bdRole.getRoleId());
        return bdRoleMapper.update(bdRole, updateWrapper);
    }

    /**
     * 删除角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public int deleteRole(Long roleId) {
        int result = 0;
        UpdateWrapper<BdRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", roleId);
        BdRole bdRole = this.getRole(roleId);
        if (bdRole != null) {
            // 无效
            bdRole.setState(0);
            result = bdRoleMapper.update(bdRole, updateWrapper);
        }
        return result;
    }
}
