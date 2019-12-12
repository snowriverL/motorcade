package com.dorcen.activity.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 优惠券第三方服务配置
 */
@Component
@PropertySource(value = {"classpath:config/coupons.properties"})
@Data
public class CouponsConfig {

    /**
     * 手机号
     */
    private String phoneno;
    /**
     * 操作次数
     */
    private Integer opnum;
    /**
     * 操作类型
     */
    @Value("${coupons.opType}")
    private Integer optype;
    /**
     * 第三方优惠券模板配置信息表的uuid
     */
    @Value("${coupons.opModle}")
    private String opmodle;
    /**
     * 访问校验的key
     */
    @Value("${coupons.accessKey}")
    private String accesskey;
    /**
     * 访问校验的key
     */
    @Value("${coupons.accessSecure}")
    private String accesssecure;
    /**
     * 第三方接口
     */
    @Value("${coupons.activityUrl}")
    private String activityUrl;

}
