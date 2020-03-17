package com.vision.girl.meet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.BdSynTerminalData;
import com.vision.girl.meet.entity.MeetBean;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Jack Road
 * @since 2019-09-23
 */
@Service("iBdSynTerminalDataService")
public interface IBdSynTerminalDataService extends IService<BdSynTerminalData> {

    /**
     * startMeeting
     *
     * @param meetBean
     * @return
     */
    ResultBean startMeeting(MeetBean meetBean);

    /**
     * createMeetUserInfo
     * 
     * @param bdSynTerminalData
     */
    void createMeetUserInfo(BdSynTerminalData bdSynTerminalData);
}
