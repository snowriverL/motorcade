package com.dorcen.activity.modules.activity.service;

import com.dorcen.activity.common.reponse.ResponseData;

/**
 * 优惠券活动Service
 */
public interface ICouponsService {

    /**
     * 通过手机号获取优惠券
     * @param mobile
     * @return
     */
    ResponseData getCouponsByMobile(String mobile);

}
