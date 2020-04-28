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

/**
 * <p>
 * 功能模块表
 * </p>
 *
 * @author Jack Road
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BdModule对象", description="功能模块表")
public class BdModule extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模块id", hidden = true)
    @TableId(value = "module_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long moduleId;

    @ApiModelProperty(value = "模块code")
    @NotBlank(message = "moduleCode不能为空")
    private String moduleCode;

    @ApiModelProperty(value = "模块名字")
    @NotBlank(message = "moduleName不能为空")
    private String moduleName;

    @ApiModelProperty(value = "父级模块code")
    private String parentModule;

    @ApiModelProperty(value = "模块路由")
    @NotBlank(message = "modeleUrl不能为空")
    private String moduleUrl;

    @ApiModelProperty(value = "状态0无效，1有效")
    private Integer state;


}
