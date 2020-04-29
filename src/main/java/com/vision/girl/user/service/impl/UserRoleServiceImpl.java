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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<ReUserRole> userRoleList = new ArrayList<>();
        // 获取当前用户已绑定的角色
        List<BdRole> bdRoleList = this.getRoleListByUserId(userId);
        // 集合移除已绑定重复的标签（求bdRoleList集合与roleList的差集）,求roleList差集
        if (bdRoleList != null && bdRoleList.size() > 0) {
            roleList = roleList.stream().filter(item -> !bdRoleList.contains(item)).collect(Collectors.toList());
        }
        roleList.forEach(bdRole -> {
            ReUserRole reUserRole = new ReUserRole();
            reUserRole.setUserId(userId);
            reUserRole.setRoleId(bdRole.getRoleId());
            // 有效状态
            reUserRole.setState(1);
            reUserRole.setCreateTime(LocalDateTime.now());
            reUserRole.setUpdateTime(LocalDateTime.now());
            userRoleList.add(reUserRole);
        });
        return userRoleService.saveBatch(userRoleList);
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
        List<ReUserRole> userRoleList = new ArrayList<>();
        // 获取当前用户绑定有效角色
        List<ReUserRole> selectRoleList = this.getReUserRoleList(userId);
        // 已绑定有效角色集合与前端发送的集合求并集
        if (selectRoleList != null && selectRoleList.size() > 0) {
            roleList = roleList.stream().filter(item -> selectRoleList.contains(item)).collect(Collectors.toList());
            if (roleList != null && roleList.size() > 0) {
                roleList.forEach(bdRole -> {
                    ReUserRole reUserRole = new ReUserRole();
                    reUserRole.setUserId(userId);
                    reUserRole.setRoleId(bdRole.getRoleId());
                    userRoleList.add(reUserRole);
                    log.info("userRoleList" + userRoleList.toString());
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
        List<ReUserRole> userRoleList = new ArrayList<>();
        roleList.forEach(bdRole -> {
            ReUserRole reUserRole = new ReUserRole();
            reUserRole.setUserId(userId);
            reUserRole.setRoleId(bdRole.getRoleId());
            reUserRole.setCreateTime(LocalDateTime.now());
            reUserRole.setUpdateTime(LocalDateTime.now());
            userRoleList.add(reUserRole);
        });
        return userRoleService.updateBatchById(userRoleList);
    }

    /**
     * 单用户所有角色列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<BdRole> getRoleListByUserId(Long userId) {
        return userRoleMapper.selectUserRoleList(userId);
    }

    /**
     * 当前用户有效的角色列表
     *
     * @param userId
     * @return
     */
    public List<ReUserRole> getReUserRoleList(Long userId) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("user_id", userId);
        // 有效状态
        map.put("state", 1);
        return userRoleMapper.selectByMap(map);
    }
}
