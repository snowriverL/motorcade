package com.dorcen.activity.exception;

import com.dorcen.activity.utils.LongIdGen;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    private long refCode;

    public long getRefCode() {
        return refCode;
    }

    public void setRefCode(long refCode) {
        this.refCode = refCode;
    }

    public BizException() {
    }

    public BizException(long refCode, String message) {
        super(message);
        this.refCode = refCode;
    }

    public BizException(String message) {
        super(message);this.InitRefCode();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.refCode = refCode;
    }

    public BizException(Throwable cause) {
        super(cause);
        if (cause instanceof BizException) {
            this.refCode =((BizException)cause).refCode;
        }
        else
            this.InitRefCode();
    }

    /**
     * 通过控制enableSuppression=false和writableStackTrace=false(没有写入stackTrace)参数，可以避免额外的开销
     */
    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.InitRefCode();
    }

    /**
     * 为当前Exception生成唯一性标识Code
     */
    public void InitRefCode()
    {
        this.refCode = LongIdGen.get().nextId();
    }

}
