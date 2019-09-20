package com.vision.girl.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @ApiModelProperty(value = "用户主键", required = true)
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    @ApiModelProperty(value = "用户name", required = true)
    private String userName;

    @ApiModelProperty(value = "用户状态0无效，1有效", required = true)
    private Integer state;

    /**
     * 表外字段
     *
     * 1.这些字段需要使用驼峰命名；
     *
     * 2.如果使用Mybatis-Plus插件，数据库表中字段必须使用下划线命名如，user_name;
     *
     * 3.Java Bean中的数据类型与数据库设计的字段类型保持一致；
     */

    private String deviceId;
    private String deviceName;
    private Long deviceNumber;
    private Long deviceState;
}
