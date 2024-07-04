package com.qianye.drools.exception;

public interface IExceptionEnum {
    /**
     * 获取错误码
     */
    String getCode();

    /**
     * 获取错误信息
     */
    String getMessage();
}