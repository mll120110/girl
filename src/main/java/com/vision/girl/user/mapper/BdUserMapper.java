package com.vision.girl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vision.girl.user.entity.BdUser;
import com.vision.girl.user.vo.UserDeviceVO;
import org.apache.ibatis.annotations.Param;
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

    @Select("SELECT " +
            "bu.user_id, " +
            "bu.user_name, " +
            "bu.state, " +
            "bd.device_id, " +
            "bd.device_name, " +
            "bd.device_number, " +
            "bd.state as device_state " +
            "FROM " +
            "re_user_device rud " +
            "JOIN bd_user bu ON rud.user_id = bu.user_id " +
            "JOIN bd_device bd ON rud.device_id = bd.device_id  " +
            "WHERE " +
            "rud.user_id = #{userId} " +
            "AND rud.state = 1")
    List<UserDeviceVO> getUserBeanList(@Param("userId") String userId);
}
