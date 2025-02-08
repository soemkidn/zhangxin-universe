package com.zhangxin.zhangxinuniverse.exception;

import com.zhangxin.zhangxinuniverse.common.StatusCode;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private final int code;

    /**
     * 描述
     */
    private final String description;

    public BusinessException(StatusCode statusCode) {
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
        this.description = statusCode.getDescription();
    }

    public BusinessException(StatusCode statusCode, String description) {
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
