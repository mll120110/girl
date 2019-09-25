package com.vision.girl.meet.service.impl;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.BdSynTerminalData;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.meet.entity.ReUserMeet;
import com.vision.girl.meet.mapper.BdSynTerminalDataMapper;
import com.vision.girl.meet.mapper.ReUserMeetMapper;
import com.vision.girl.meet.service.IBdSynTerminalDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2019-09-23
 */
@Service
public class BdSynTerminalDataServiceImpl extends ServiceImpl<BdSynTerminalDataMapper, BdSynTerminalData>
    implements IBdSynTerminalDataService {

    @Autowired
    BdSynTerminalDataMapper bdSynTerminalDataMapper;

    @Autowired
    ReUserMeetMapper reUserMeetMapper;

    /**
     * createMeetUserInfo
     *
     * @param bdSynTerminalData
     */
    @Override
    @Transactional
    public void createMeetUserInfo(BdSynTerminalData bdSynTerminalData) {
        // 构建会议数据
        bdSynTerminalData.setMeetId(UUID.randomUUID().toString());
        // 构建会议与user关系数据
        ReUserMeet reUserMeet = new ReUserMeet();
        reUserMeet.setReUserMeetId(UUID.randomUUID().toString());
        reUserMeet.setMeetId(bdSynTerminalData.getMeetId());
        reUserMeet.setUserId("");
        reUserMeet.setState(1);
        reUserMeet.setCreateTime(LocalDateTime.now());
        reUserMeet.setUpdateTime(LocalDateTime.now());
        // 保存会议数据
        bdSynTerminalDataMapper.insert(bdSynTerminalData);
        // 保存会议与user关系数据
        reUserMeetMapper.insert(reUserMeet);
    }

    /**
     * startMeeting
     *
     * @param meetBean
     * @return
     */
    @Override
    public ResultBean startMeeting(MeetBean meetBean) {
        // 验证userid绑定的会管账户有效性

        return null;
    }

    /**
     * 会议于用户表关联会议信息
     * 
     * @param userId
     * @return
     */
    public BdSynTerminalData getBdSynTerminalData(String userId) {
        return bdSynTerminalDataMapper.getBdSynTerminalData(userId);
    }

    // public String check
}
