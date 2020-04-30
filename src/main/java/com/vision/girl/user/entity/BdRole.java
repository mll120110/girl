package com.vision.girl.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vision.girl.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BdRole对象", description="角色表")
public class BdRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id", hidden = true)
    @TableId(value = "role_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    @ApiModelProperty(value = "角色编码")
    @NotBlank(message = "roleCode不能为空")
    private String roleCode;

    @ApiModelProperty(value = "角色name")
    @NotBlank(message = "roleName不能为空")
    private String roleName;

    @ApiModelProperty(value = "状态0无效，1有效")
    private Integer state;

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleCode, state);
    }
}
