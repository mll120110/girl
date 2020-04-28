package com.vision.girl.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vision.girl.user.entity.BdRole;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
public interface IBdRoleService extends IService<BdRole> {
    int createRole(BdRole bdRole);

    BdRole getRole(Long roleId);

    IPage<BdRole> getRoleList(int startPage, int endPage);

    int updateRole(com.vision.girl.user.entity.BdRole bdRole, Long roleId);

    int deleteRole(Long roleId);
}
