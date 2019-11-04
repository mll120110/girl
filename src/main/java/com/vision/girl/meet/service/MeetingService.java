package com.vision.girl.meet.service;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import org.springframework.stereotype.Service;

@Service("meetingService")
public interface MeetingService {

    /**
     * 开始会议
     * 
     * @param meetBean
     * @return
     */
    ResultBean startMeeting(MeetBean meetBean);
}
