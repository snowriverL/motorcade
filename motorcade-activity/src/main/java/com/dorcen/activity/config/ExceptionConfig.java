package com.dorcen.activity.config;

import com.dorcen.activity.common.reponse.ResultEnums;
import com.dorcen.activity.exception.BizException;
import com.dorcen.activity.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ExceptionConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionConfig.class);

    /**
     * 捕捉ValidationException
     *
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    public Object validationException(ValidationException ex) {
        LOGGER.error("业务参数错误", ex);
        return ResponseUtil.buildError(ResultEnums.VERIFY_CODE_ERROR);
    }

    /**
     * 捕捉其他所有异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object globalException(Throwable ex) {
        LOGGER.error("系统异常", ex);
        return ResponseUtil.buildError(ResultEnums.SYSTEM_ERROR);
    }

    /**
     * 捕捉业务逻辑异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BizException.class)
    public Object bizException(Throwable ex) {
        LOGGER.error("业务逻辑错误", ex);
        return ResponseUtil.buildError(ResultEnums.BUSSINESS_ERROR);
    }

}