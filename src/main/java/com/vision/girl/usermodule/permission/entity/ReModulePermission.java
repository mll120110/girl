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
 * 模块与权限关系表
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ReModulePermission对象", description="模块与权限关系表")
public class ReModulePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "re_module_permission_id", type = IdType.UUID)
    private String reModulePermissionId;

    @ApiModelProperty(value = "模块表主键id")
    private String moduleId;

    @ApiModelProperty(value = "权限表主键id")
    private String permissionId;

    @ApiModelProperty(value = "状态0无效，1有效")
    private Integer state;


}
