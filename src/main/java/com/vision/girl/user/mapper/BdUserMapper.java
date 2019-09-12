package com.vision.girl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vision.girl.user.entity.BdUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
public interface BdUserMapper extends BaseMapper<BdUser> {

    @Select("select * from bd_user where 1=1 limit 0,1")
    BdUser getUserInfo();

    List<BdUser> getUserInfoTwo();
}
