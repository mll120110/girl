package com.vision.girl.meet.controller;

import com.vision.girl.common.ResultBean;
import com.vision.girl.meet.entity.MeetBean;
import com.vision.girl.meet.service.MeetingService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 会议模块
 * 
 * @author Jack Road
 * @since 2019-10-28
 */
@Slf4j
@RestController
@RequestMapping("/meeting/")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @PostMapping(value = "starMeeting")
    @ApiOperation(value = "开始会议")
    public ResultBean startMeeting(@Valid @RequestBody MeetBean meetBean) {
        return meetingService.startMeeting(meetBean);
    }

    @PostMapping(value = "dynamicJoin")
    @ApiOperation(value = "动态加入会议")
    public ResultBean dynamicJoin(@RequestBody MeetBean meetBean) {
        return null;
    }

    @PostMapping(value = "dynamicRemove")
    @ApiOperation(value = "动态移除会议")
    public ResultBean dynamicRemove(@RequestBody MeetBean meetBean) {
        return null;
    }

    @PostMapping(value = "stopMeeting")
    @ApiOperation(value = "停止会议")
    public ResultBean stopMeeting(@RequestBody MeetBean meetBean) {
        return null;
    }
}
