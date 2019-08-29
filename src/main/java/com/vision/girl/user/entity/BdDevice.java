package com.vision.girl.user.entity;

import com.vision.girl.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
@ApiModel(value="BdDevice对象", description="")
public class BdDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "设备name")
    private String deviceName;

    @ApiModelProperty(value = "设备号")
    private Integer deviceNumber;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
