package com.vision.girl.meet.controller;

import com.vision.girl.meet.entity.BdSynTerminalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.girl.common.BaseController;
import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.meet.service.IBdSynTerminalDataService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jack Road
 * @since 2019-09-23
 */
@Slf4j
@RestController
@RequestMapping("/meet/bd-syn-terminal-data")
public class BdSynTerminalDataController extends BaseController {

    @Autowired
    @Qualifier("iBdSynTerminalDataService")
    IBdSynTerminalDataService iBdSynTerminalDataService;

    /**
     * createMeetUserInfo
     * 
     * @param bdSynTerminalData
     * @return
     */
    @PostMapping(value = "createMeetUserInfo")
    @ApiOperation(value = "创建用户与会议账户关系")
    public ResultBean createMeetUserInfo(@RequestBody BdSynTerminalData bdSynTerminalData) {
        iBdSynTerminalDataService.createMeetUserInfo(bdSynTerminalData);
        return ResultBean.success();
    }

    /**
     * startMeeting
     * 
     * @param meetBean
     * @return
     */
    @PostMapping(value = "startMeeting")
    @ApiOperation(value = "开始会议")
    public ResultBean startMeeting(@RequestBody MeetBean meetBean) {
        return ResultBean.success(iBdSynTerminalDataService.startMeeting(meetBean));
    }
}
