package com.vision.girl.meet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BdSynTerminalData对象", description="")
public class BdSynTerminalData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "meet_id", type = IdType.UUID)
    private String meetId;

    @ApiModelProperty(value = "会议名称")
    private String meetName;

    @ApiModelProperty(value = "会议类型")
    private Integer meetType;

    @ApiModelProperty(value = "会议服务地址url")
    private String meetService;

    @ApiModelProperty(value = "会议账户")
    private String meetAccount;

    @ApiModelProperty(value = "会议密码")
    private String meetPassword;

    @ApiModelProperty(value = "会议token")
    private String meetToken;

    @ApiModelProperty(value = "会议账户是否通过校验")
    @TableField("isCheck")
    private Integer isCheck;

    @ApiModelProperty(value = "会议状态")
    private Integer state;
}
