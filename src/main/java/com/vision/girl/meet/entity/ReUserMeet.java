package com.vision.girl.meet.entity;

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
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ReUserMeet对象", description = "")
public class ReUserMeet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会议与用户关系主键")
    @TableId(value = "re_user_meet_id", type = IdType.UUID)
    private String reUserMeetId;

    @ApiModelProperty(value = "用户表主键")
    private String userId;

    @ApiModelProperty(value = "会议表主键")
    private String meetId;

    @ApiModelProperty(value = "用户状态0无效，1有效", required = true)
    private Integer state;

}
