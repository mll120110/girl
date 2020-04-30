package com.vision.girl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vision.girl.user.entity.BdRole;
import com.vision.girl.user.entity.ReUserRole;
import com.vision.girl.user.mapper.UserRoleMapper;
import com.vision.girl.user.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jack Road
 * @since 2020-04-29
 */
@Slf4j
@Service(value = "userRoleServiceImpl")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, ReUserRole> implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    @Qualifier(value = "userRoleServiceImpl")
    UserRoleService userRoleService;

    /**
     * 单用户关联角色列表
     *
     * @param userId
     * @param roleList
     * @return
     */
    @Override
    public boolean createUserRole(Long userId, List<BdRole> roleList) {
        boolean addResult = false;
        List<BdRole> addList = roleList;;
        List<ReUserRole> userRoleList = new ArrayList<>();
        // 获取当前用户已绑定的角色
        List<BdRole> bdRoleList = this.getRoleListByUserId(userId, -1);
        // 若用户已存在绑定角色
        if (bdRoleList != null && bdRoleList.size() > 0) {
            // 取差集
            addList = roleList.stream().filter(newRole -> !bdRoleList.stream().map(oldRole -> oldRole.hashCode())
                .collect(Collectors.toList()).contains(newRole.hashCode())).collect(Collectors.toList());
        }
        if (addList != null && addList.size() > 0) {
            addList.forEach(bdRole -> {
                ReUserRole reUserRole = new ReUserRole();
                reUserRole.setUserId(userId);
                reUserRole.setRoleId(bdRole.getRoleId());
                // 有效状态
                reUserRole.setState(1);
                reUserRole.setCreateTime(LocalDateTime.now());
                reUserRole.setUpdateTime(LocalDateTime.now());
                userRoleList.add(reUserRole);
            });
            addResult = userRoleService.saveBatch(userRoleList);
        }
        return addResult;
    }

    /**
     * 单用户移除角色列表
     *
     * @param userId
     * @param roleList
     * @return
     */
    @Override
    public boolean removeUserRole(Long userId, List<BdRole> roleList) {
        boolean restult = false;
        List<BdRole> removeList;
        List<ReUserRole> userRoleList = new ArrayList<>();
        // 获取当前用户绑定有效角色
        List<BdRole> selectRoleList = this.getRoleListByUserId(userId, 1);
        //
        if (selectRoleList != null && selectRoleList.size() > 0) {
            removeList = roleList.stream().filter(newRole -> selectRoleList.stream().map(oldRole -> oldRole.hashCode())
                .collect(Collectors.toList()).contains(newRole.hashCode())).collect(Collectors.toList());
            if (removeList != null && removeList.size() > 0) {
                removeList.forEach(bdRole -> {
                    ReUserRole reUserRole = new ReUserRole();
                    reUserRole.setUserId(userId);
                    reUserRole.setRoleId(bdRole.getRoleId());
                    userRoleList.add(reUserRole);
                });
                restult = userRoleMapper.updateUserRoleList(userRoleList);
            }
        }
        return restult;
    }

    /**
     * 单用户更新角色列表
     *
     * @param userId
     * @param roleList
     * @return
     */
    @Override
    public boolean updateUserRole(Long userId, List<BdRole> roleList) {
        boolean updateResult = false;
        List<BdRole> updateList = null;
        List<ReUserRole> userRoleList = new ArrayList<>();
        // 获取当前绑定用户所有角色(包含无效、有效的所有角色)
        List<BdRole> selectRoleList = this.getRoleListByUserId(userId, -1);
        if (selectRoleList != null && selectRoleList.size() > 0) {
            updateList = roleList.stream().filter(item -> selectRoleList.stream().map(e -> e.hashCode())
                .collect(Collectors.toList()).contains(item.hashCode())).collect(Collectors.toList());
        }
        if (updateList != null && updateList.size() > 0) {
            updateList.forEach(bdRole -> {
                ReUserRole reUserRole = new ReUserRole();
                reUserRole.setUserId(userId);
                reUserRole.setRoleId(bdRole.getRoleId());
                reUserRole.setCreateTime(LocalDateTime.now());
                reUserRole.setUpdateTime(LocalDateTime.now());
                userRoleList.add(reUserRole);
            });
            updateResult = userRoleMapper.updateUserRoleList(userRoleList);
        }
        return updateResult;
    }

    /**
     * 单用户所有角色列表
     *
     * @param userId
     * @Param state
     * @return
     */
    @Override
    public List<BdRole> getRoleListByUserId(Long userId, Integer state) {
        return userRoleMapper.selectUserRoleList(userId, state);
    }
}
