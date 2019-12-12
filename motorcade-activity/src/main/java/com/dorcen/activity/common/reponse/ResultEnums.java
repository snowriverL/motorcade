package com.dorcen.activity.common.reponse;

public enum ResultEnums {

    SUCCESS("200", "请求成功"),
    ERROR("1111", "请求失败"),
    SYSTEM_ERROR("1000", "系统异常"),
    BUSSINESS_ERROR("2001", "业务逻辑错误"),
    VERIFY_CODE_ERROR("2002", "业务参数错误"),

    COUPONS_SUCCESS("200", "领取优惠券成功"),
    COUPONS_FAILED("3001", "您已经领取过优惠券"),
    MOBILE_ERROR("3002", "手机号格式不正确，请重新输入"),
    COUPONS_ERROR("3003", "领取优惠券失败，请重新领取");

    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}