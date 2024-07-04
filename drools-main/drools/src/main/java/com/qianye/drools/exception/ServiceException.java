package com.qianye.drools.exception;

/**
 * 描述：服务层自定义异常
 * CLASSPATH: com.sky.lli.exception.ServiceException.java
 * VERSION:   1.0
 */
public class ServiceException extends EnumException {

    private static final long serialVersionUID = 1L;

    public ServiceException(IExceptionEnum responseEnum, String suffix) {
        super(responseEnum, suffix);
    }

    public ServiceException(IExceptionEnum responseEnum) {
        super(responseEnum);
    }

}
