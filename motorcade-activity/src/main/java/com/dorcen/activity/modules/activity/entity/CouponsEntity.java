package com.dorcen.activity.modules.activity.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 优惠券活动Entity
 */
@Data
@TableName("coupons")
public class CouponsEntity {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;
    /**
     * 领取状态,1-成功,0-失败
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 领取优惠券返回状态
     */
    @TableField(value = "code")
    private Integer code;
    /**
     * 领取优惠券返回信息
     */
    @TableField(value = "msg")
    private String msg;
    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 修改人
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;
    /**
     * 删除标记
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private Integer delFlag;

}