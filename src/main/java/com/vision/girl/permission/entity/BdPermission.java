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
@ApiModel(value="BdPermission对象", description="")
public class BdPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "permission_id", type = IdType.UUID)
    private String permissionId;

    private String permissionCode;

    private String permissionName;

    private Integer state;


}
