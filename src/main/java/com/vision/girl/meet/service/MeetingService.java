package com.vision.girl.meet.service;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.entity.BdUser;
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

    /**
     * 校验账号
     * 
     * @param bdUser
     * @return
     */
    ResultBean checkAccount(BdUser bdUser);

    /**
     * 主席
     * 
     * @param bdDevices
     * @return
     */
    ResultBean chairmanJoinMeeting(BdDevice[] bdDevices);

    /**
     * 终端
     * 
     * @param bdDevices
     * @return
     */
    ResultBean terminalJoinMeeting(BdDevice[] bdDevices);

    /**
     * 监控
     * 
     * @param bdDevices
     * @return
     */
    ResultBean monitorJoinMeeting(BdDevice[] bdDevices);

    /**
     * 虚拟终端
     * 
     * @param bdDevices
     * @return
     */
    ResultBean virtualTerminalJoinMeeting(BdDevice[] bdDevices);

    /**
     * 
     * @return
     */
    ResultBean successDevice();

    /**
     * 
     * @return
     */
    ResultBean errorDevice();
}
