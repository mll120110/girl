package com.vision.girl.user.entity;

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
@ApiModel(value = "BdUser对象", description = "")
public class BdUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    private String userId;

    @ApiModelProperty(value = "用户name")
    private String userName;

    @ApiModelProperty(value = "用户状态")
    private Integer state;
}
