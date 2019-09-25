package com.vision.girl.meet.mapper;

import com.vision.girl.meet.entity.BdSynTerminalData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Jack Road
 * @since 2019-09-23
 */
public interface BdSynTerminalDataMapper extends BaseMapper<BdSynTerminalData> {

    /**
     * 会议于用户表关联会议账号信息
     *
     * @param userId
     * @return
     */
    @Select("SELECT " +
            "bstd.* " +
            "FROM " +
            "re_user_meet rum " +
            "JOIN bd_syn_terminal_data bstd ON rum.meet_id = bstd.meet_id  " +
            "WHERE " +
            " run.state = 1 AND rum.user_id = #{userId}")
    BdSynTerminalData getBdSynTerminalData(@Param("userId") String userId);
}
