package com.vision.girl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vision.girl.device.entity.ReUserDevice;
import com.vision.girl.device.mapper.ReUserDeviceMapper;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.entity.UserDeviceBean;
import com.vision.girl.user.mapper.BdUserMapper;
import com.vision.girl.user.service.IBdUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Slf4j
@Service(value = "bdUserServiceImpl")
public class BdUserServiceImpl extends ServiceImpl<BdUserMapper, BdUser> implements IBdUserService {

    @Autowired
    BdUserMapper bdUserMapper;

    @Autowired
    ReUserDeviceMapper reUserDeviceMapper;

    /**
     * 新增用户
     *
     * @param bdUser
     * @return
     */
    public int createUser(BdUser bdUser) {
        return bdUserMapper.insert(bdUser);
    }

    /**
     * 更新用户信息
     *
     * @param bdUser
     * @return
     */
    @Override
    public int updateUser(BdUser bdUser) {
        return bdUserMapper.update(bdUser, null);
    }

    /**
     * 新增用户、用户与设备绑定关系数据
     * 
     * @param userDeviceBean
     * @return
     */
    @Override
    @Transactional
    public int createUserAndDevice(UserDeviceBean userDeviceBean) {
        // 新增user数据
        int userResult = bdUserMapper.insert(userDeviceBean.getBdUser());
        // 实例化user与device关系数据
        ReUserDevice reUserDevice = new ReUserDevice();
        reUserDevice.setUserDeviceId(UUID.randomUUID().toString());
        reUserDevice.setUserId(userDeviceBean.getBdUser().getUserId());
        reUserDevice.setDeviceId(userDeviceBean.getBdDevice().getDeviceId());
        // 状态0，无效，1有效
        reUserDevice.setState(1);
        // 创建时间
        reUserDevice.setCreateTime(LocalDateTime.now());
        // 更新时间
        reUserDevice.setUpdateTime(LocalDateTime.now());
        int userDeviceResult = reUserDeviceMapper.insert(reUserDevice);
        return userResult + userDeviceResult;
    }
}
