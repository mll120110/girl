package com.vision.girl.user.entity;

import com.vision.girl.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 获取User、Device的Bean
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "获取User、Device的Bean", description = "获取User、Device的Bean")
public class UserDeviceBean extends BaseEntity {
    private static final long serialVersionUID = -6426136190420194776L;

    @ApiModelProperty(value = "BdUser对象")
    private BdUser bdUser;

    @ApiModelProperty(value = "BdDevice对象")
    private BdDevice bdDevice;

    @ApiModelProperty(value = "状态0：无效，1有效")
    private Integer state;
}
