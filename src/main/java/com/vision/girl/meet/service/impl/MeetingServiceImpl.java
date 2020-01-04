package com.vision.girl.meet.service.impl;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.meet.service.MeetingService;
import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.entity.BdUser;
import org.springframework.stereotype.Service;

/**
 * 正常开会
 */
@Service(value = "meetingServiceImpl")
public class MeetingServiceImpl implements MeetingService {

    @Override
    public ResultBean startMeeting(MeetBean meetBean) {
        return null;
    }

    @Override
    public ResultBean checkAccount(BdUser bdUser) {
        return null;
    }

    @Override
    public ResultBean chairmanJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    @Override
    public ResultBean terminalJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    @Override
    public ResultBean monitorJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    @Override
    public ResultBean virtualTerminalJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    @Override
    public ResultBean successDevice() {
        return null;
    }

    @Override
    public ResultBean errorDevice() {
        return null;
    }
}
