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

    @ApiModelProperty(value = "模块id")
    @TableId(value = "module_id", type = IdType.UUID)
    private String moduleId;

    @ApiModelProperty(value = "模块code")
    private String moduleCode;

    @ApiModelProperty(value = "模块名字")
    private String modeleName;

    @ApiModelProperty(value = "父级模块code")
    private String parentModule;

    @ApiModelProperty(value = "模块路由")
    private String modeleUrl;

    @ApiModelProperty(value = "状态0无效，1有效")
    private Integer state;


}
