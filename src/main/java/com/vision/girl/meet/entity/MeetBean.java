package com.vision.girl.meet.entity;

import com.vision.girl.user.entity.BdDevice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 获取开会相关参数
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "会议参数Json", description = "会议参数Json")
public class MeetBean {
    private static final long serialVersionUID = -6426136190420194765L;

    @NotNull
    @ApiModelProperty(value = "主席设备信息List", position = 1, required = true)
    private BdDevice[] defaultDeviceList;

    @NotNull
    @ApiModelProperty(value = "终端设备List", position = 2, required = true, allowEmptyValue = true)
    private BdDevice[] terminalList;

    @NotNull
    @ApiModelProperty(value = "监控设备List", position = 3, required = true, allowEmptyValue = true)
    private BdDevice[] monitorList;

    @NotNull
    @ApiModelProperty(value = "虚拟终端设备List", position = 4, required = true, allowEmptyValue = true)
    private BdDevice[] virtualDeviceList;

    @ApiModelProperty(value = "会议类型", position = 5, required = true)
    private Integer meetMode;

    @ApiModelProperty(value = "gis系统会议业务类型", position = 6, required = true)
    private Integer gisMeetMode;

    @ApiModelProperty(value = "会议类型", position = 7, required = true)
    private Integer meetSubMode;

    @ApiModelProperty(value = "设置屏幕", position = 8, required = true)
    private Integer screenType;

    @ApiModelProperty(value = "是否停会标示", position = 9, required = true)
    private Integer isStoping;

    @NotNull
    @ApiModelProperty(value = "当前登录系统的用户id", position = 10, required = true)
    private String userId;
}
