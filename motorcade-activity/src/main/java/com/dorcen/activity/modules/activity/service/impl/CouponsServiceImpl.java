package com.dorcen.activity.modules.activity.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dorcen.activity.common.reponse.ResponseData;
import com.dorcen.activity.common.reponse.ResultEnums;
import com.dorcen.activity.config.CouponsConfig;
import com.dorcen.activity.modules.activity.entity.CouponsEntity;
import com.dorcen.activity.modules.activity.mapper.CouponsMapper;
import com.dorcen.activity.modules.activity.service.ICouponsService;
import com.dorcen.activity.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponsServiceImpl implements ICouponsService {

    @Autowired
    private CouponsConfig couponsConfig;

    @Autowired
    private CouponsMapper couponsMapper;

    @Override
    public ResponseData getCouponsByMobile(String mobile) {
        // 查询用户是否领取过优惠券
        Integer count = couponsMapper.selectCount(Wrappers.<CouponsEntity>lambdaQuery().eq(CouponsEntity :: getMobile, mobile));
        if (ObjectUtil.notEqual(0, count)) {
            log.info("用户已经领取过优惠券, 手机号:{}", mobile);
            return ResponseUtil.buildError(ResultEnums.COUPONS_FAILED);
        }

        CouponsEntity couponsEntity = new CouponsEntity();
        couponsConfig.setPhoneno(mobile);

        log.info("调用第三方优惠券服务, 调用参数:{}", JSONObject.toJSONString(couponsConfig));

        log.info("调用第三方优惠券服务, 调用成功, 返回结果:{}");

        // 请求成功录入数据库
        couponsEntity.setMobile(mobile);
        couponsEntity.setCode(200);
        couponsEntity.setStatus(1);
        couponsEntity.setMsg("");

        couponsMapper.insert(couponsEntity);
        log.info("领取优惠券成功, 手机号:{}", mobile);
        return ResponseUtil.buildSuccess(ResultEnums.COUPONS_SUCCESS);
    }
}
