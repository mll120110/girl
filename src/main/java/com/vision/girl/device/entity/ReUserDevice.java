package com.vision.girl.device.entity;

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
@ApiModel(value="ReUserDevice对象", description="")
public class ReUserDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户与设备关系id")
    private String userDeviceId;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
