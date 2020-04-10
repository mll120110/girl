package com.vision.girl.permission.entity;

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
 * 
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ReModulePermission对象", description="")
public class ReModulePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "re_module_permission", type = IdType.UUID)
    private String reModulePermission;

    private String moduleId;

    private String permissionId;

    private Integer state;


}
