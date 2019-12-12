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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}