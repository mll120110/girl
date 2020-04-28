package com.vision.girl.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vision.girl.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BdPermission对象", description="权限表")
public class BdPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id", hidden = true)
    @TableId(value = "permission_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String permissionId;

    @ApiModelProperty(value = "权限编码")
    @NotBlank(message = "permissionCode不能为空")
    private String permissionCode;

    @ApiModelProperty(value = "权限名字")
    @NotBlank(message = "permissionName不能为空")
    private String permissionName;

    @ApiModelProperty(value = "状态0无效，1有效")
    private Integer state;


}
