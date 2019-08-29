package com.vision.girl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.mapper.BdUserMapper;
import com.vision.girl.user.service.IBdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Service(value = "bdUserServiceImpl")
public class BdUserServiceImpl extends ServiceImpl<BdUserMapper, BdUser> implements IBdUserService {

    @Autowired
    BdUserMapper bdUserMapper;

    /**
     * 新增用户
     *
     * @param bdUser
     * @return
     */
    public int createUser(BdUser bdUser) {
        return bdUserMapper.insert(bdUser);
    }

    @Override
    public int updateUser(BdUser bdUser) {
        return bdUserMapper.update(bdUser, null);
    }
}
