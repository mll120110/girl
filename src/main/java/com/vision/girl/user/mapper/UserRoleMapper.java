package com.vision.girl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.entity.ReUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<ReUserRole> {

    /**
     * 单用户移除角色列表
     * 
     * @param reUserRoleList
     * @return
     */
    boolean updateUserRoleList(List<ReUserRole> reUserRoleList);

    /**
     * 单用户所有角色列表
     * 
     * @param userId
     * @return
     */
    List<BdRole> selectUserRoleList(@Param(value = "userId") Long userId);
}
