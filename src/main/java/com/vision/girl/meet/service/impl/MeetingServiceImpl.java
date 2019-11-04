package com.vision.girl.meet.service.impl;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.meet.service.MeetingService;
import com.vision.girl.user.entity.BdDevice;
import org.springframework.stereotype.Service;

@Service(value = "meetingServiceImpl")
public class MeetingServiceImpl implements MeetingService {
    /**
     * 开始会议
     * 
     * @param meetBean
     * @return
     */
    @Override
    public ResultBean startMeeting(MeetBean meetBean) {
        // 获取主席设备信息
        BdDevice[] defaultDeviceList = meetBean.getDefaultDeviceList();
        if (defaultDeviceList.length > 0) {
            chairmanStartMeeting(defaultDeviceList);
        }
        // 获取终端列表
        BdDevice[] terminalList = meetBean.getTerminalList();
        if (terminalList.length > 0) {
            terminalJoinMeeting(terminalList);
        }

        // 获取监控列表
        BdDevice[] monitorList = meetBean.getMonitorList();
        if (monitorList.length > 0) {
            monitoringJoinMeeting(monitorList);
        }

        // 获取虚拟终端列表
        BdDevice[] virtualDeviceList = meetBean.getVirtualDeviceList();
        if (virtualDeviceList.length > 0) {
            virtualMonitoringJoinMeeting(virtualDeviceList);
        }
        return ResultBean.success(meetBean);
    }

    /**
     * 主席开启会议
     *
     * @param bdDevices
     * @return
     */
    public ResultBean chairmanStartMeeting(BdDevice[] bdDevices) {
        return null;
    }

    /**
     * 终端入会
     *
     * @param bdDevices
     * @return
     */
    public ResultBean terminalJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    /**
     * 监控入会
     *
     * @param bdDevices
     * @return
     */
    public ResultBean monitoringJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }

    /**
     * 虚拟终端入会
     *
     * @param bdDevices
     * @return
     */
    public ResultBean virtualMonitoringJoinMeeting(BdDevice[] bdDevices) {
        return null;
    }
}
