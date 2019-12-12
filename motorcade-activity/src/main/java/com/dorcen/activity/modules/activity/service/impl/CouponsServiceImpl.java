package com.dorcen.activity.modules.activity.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
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

import static com.dorcen.activity.common.constant.Constant.*;

@Slf4j
@Service
public class CouponsServiceImpl implements ICouponsService {

    @Autowired
    private CouponsConfig couponsConfig;

    @Autowired
    private CouponsMapper couponsMapper;

    @Override
    public ResponseData getCouponsByMobile(String mobile) {
        if (!Validator.isMobile(mobile)) {
            return ResponseUtil.buildError(ResultEnums.MOBILE_ERROR);
        }

        // 查询用户是否领取过优惠券
        Integer count = couponsMapper.selectCount(Wrappers.<CouponsEntity>lambdaQuery().eq(CouponsEntity :: getMobile, mobile));
        if (ObjectUtil.notEqual(0, count)) {
            log.info("用户已经领取过优惠券, 手机号:{}", mobile);
            return ResponseUtil.buildError(ResultEnums.COUPONS_FAILED);
        }

        couponsConfig.setPhoneno(mobile);
        couponsConfig.setOpnum(1);
        log.info("调用第三方优惠券服务, 调用参数:{}", JSONObject.toJSONString(couponsConfig));
        HttpRequest request = HttpUtil.createPost(couponsConfig.getActivityUrl());
        request.contentType("application/json");
        request.body(JSONObject.toJSONString(couponsConfig));
        JSONObject result = JSONObject.parseObject(request.execute().body());
        log.info("调用第三方优惠券服务, 返回结果:{}", result);
        if (ObjectUtil.notEqual(SUCCESS_CODE, result.getInteger(CODE))) {
            return ResponseUtil.buildError(ResultEnums.COUPONS_ERROR);
        }

        insertCoupons(mobile, result);
        log.info("领取优惠券成功, 手机号:{}", mobile);
        return ResponseUtil.buildSuccess(ResultEnums.COUPONS_SUCCESS);
    }

    /**
     * 保存优惠券领取记录
     * @param mobile
     * @param result
     */
    private void insertCoupons(String mobile, JSONObject result) {
        // 请求成功录入数据库
        CouponsEntity couponsEntity = new CouponsEntity();
        couponsEntity.setMobile(mobile);
        couponsEntity.setCode(result.getInteger(CODE));
        couponsEntity.setStatus(1);
        couponsEntity.setMsg(result.getString(MSG));

        couponsMapper.insert(couponsEntity);
    }
}
