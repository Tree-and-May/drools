package com.qianye.drools.attribute.parser;

public class CommonUtil {
    public static StringBuilder appendClassName(Class clazz) {
        String className = clazz.getSimpleName();
        return new StringBuilder(Character.toUpperCase(className.charAt(0))
                + className.substring(1));
    }

    public static StringBuilder appendAttributeName(String value) {
        return new StringBuilder()
                .append(Constants.ATTRIBUTE_NAME)
                .append(Constants.EQUAL)
                .append(Constants.QUOTATION)
                .append(value)
                .append(Constants.QUOTATION);
    }
}
