package com.vision.girl.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.entity.ReUserRole;

import java.util.List;

/**
 *
 *
 *
 * @author Jack Road
 * @since 2020-04-29
 */
public interface UserRoleService extends IService<ReUserRole> {

    /**
     * 单用户关联角色列表
     * 
     * @param userId
     * @param roleList
     * @return
     */
    boolean createUserRole(Long userId, List<BdRole> roleList);

    /**
     * 单用户移除角色列表
     * 
     * @param userId
     * @param roleList
     * @return
     */
    boolean removeUserRole(Long userId, List<BdRole> roleList);

    /**
     * 单用户更新角色列表
     * 
     * @param userId
     * @param roleList
     * @return
     */
    boolean updateUserRole(Long userId, List<BdRole> roleList);

    /**
     * 单用户所有角色列表
     * 
     * @param userId
     * @return
     */
    List<BdRole> getRoleListByUserId(Long userId);

}
