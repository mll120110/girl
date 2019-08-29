package com.vision.girl.user.service;

import com.vision.girl.user.entity.BdUser;
import com.baomidou.mybatisplus.extension.service.IService;

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

    int updateUser(BdUser bdUser);
}
