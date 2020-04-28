package com.vision.girl.device.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.vision.girl.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ReUserDevice对象", description = "")
public class ReUserDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户与设备关系id")
    @TableId(type = IdType.NONE)
    private String userDeviceId;

    @ApiModelProperty(value = "用户表外键id")
    @TableField(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "设备表外键id")
    @TableField(value = "device_id")
    private String deviceId;

    @ApiModelProperty(value = "状态")
    private Integer state;
}
