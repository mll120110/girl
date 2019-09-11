package com.vision.girl.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.vision.girl.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * BdDevice对象
 * 
 * @author Jack Road
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BdDevice对象", description = "")
public class BdDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.UUID)
    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "设备name")
    private String deviceName;

    @ApiModelProperty(value = "设备号")
    private Long deviceNumber;

    @ApiModelProperty(value = "设备状态0无效，1有效")
    private Integer state;
}
