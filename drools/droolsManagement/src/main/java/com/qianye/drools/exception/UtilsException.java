package com.qianye.drools.exception;

/**
 * 描述：服务层自定义异常
 * VERSION:   1.0
 */
public class UtilsException extends EnumException {

    private static final long serialVersionUID = 1L;

    public UtilsException(IExceptionEnum responseEnum, String suffix) {
        super(responseEnum, suffix);
    }

    public UtilsException(IExceptionEnum responseEnum) {
        super(responseEnum);
    }

}
