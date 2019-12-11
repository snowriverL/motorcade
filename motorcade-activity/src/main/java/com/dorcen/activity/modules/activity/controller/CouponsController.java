package com.dorcen.activity.modules.activity.controller;

import com.dorcen.activity.common.reponse.ResponseData;
import com.dorcen.activity.modules.activity.service.ICouponsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 优惠券活动Controller
 */
@RestController
@RequestMapping("activity/coupons")
@Slf4j
public class CouponsController {

    @Autowired
    private ICouponsService couponsService;

    @PostMapping("get/{mobile}")
    public ResponseData getCoupons(@PathVariable String mobile) {
        log.info("获取优惠券手机号:{}" , mobile);
        return couponsService.getCouponsByMobile(mobile);
    }

}
