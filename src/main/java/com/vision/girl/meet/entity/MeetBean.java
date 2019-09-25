package com.vision.girl.meet.entity;

import com.vision.girl.user.entity.BdDevice;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 获取开会相关参数
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "获取User、Device的Bean", description = "获取User、Device的Bean")
public class MeetBean {
    private static final long serialVersionUID = -6426136190420194765L;

    private String userId;

    private List<BdDevice> terminalList;

    private List<BdDevice> defaultDeviceList;

    private List<BdDevice> monitorList;

}
