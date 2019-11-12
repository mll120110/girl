package com.vision.girl.user.vo;

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
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BdUser对象", description = "")
public class UserDeviceVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键", required = true)
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    @ApiModelProperty(value = "用户name", required = true)
    private String userName;

    @ApiModelProperty(value = "用户状态0无效，1有效", required = true)
    private Integer state;

    @ApiModelProperty(value = "设备id", required = true)
    @TableField(value = "device_id")
    private String deviceId;

    @ApiModelProperty(value = "设备名称", required = true)
    private String deviceName;

    @ApiModelProperty(value = "设备号", required = true)
    private Long deviceNumber;

    @ApiModelProperty(value = "设备状态0，无效；1，有效", required = true)
    private Long deviceState;
}
