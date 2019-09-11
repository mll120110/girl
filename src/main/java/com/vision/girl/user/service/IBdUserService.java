package com.vision.girl.user.service;

import com.vision.girl.user.entity.BdUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vision.girl.user.entity.UserDeviceBean;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
public interface IBdUserService extends IService<BdUser> {
    /**
     * 新增用户
     * 
     * @param bdUser
     * @return
     */
    int createUser(BdUser bdUser);

    /**
     * 更新用户信息
     *
     * @param bdUser
     * @return
     */
    int updateUser(BdUser bdUser);

    /**
     * 新增用户、用户与设备绑定关系数据
     *
     * @param userDeviceBean
     * @return
     */
    int createUserAndDevice(UserDeviceBean userDeviceBean);
}
