package com.vision.girl.usermodule.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.vision.girl.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色与re_module_permission关系表
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ReRoleRmp对象", description="角色与re_module_permission关系表")
public class ReRoleRmp extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "re_role_permission_id", type = IdType.UUID)
    private String reRolePermissionId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "模块与权限表主键id")
    private String rmpId;

    @ApiModelProperty(value = "状态")
    private Integer state;


}
