package com.qianye.drools.attribute.parser;

public abstract class BaseParser {
    private String attributeName;

    private Object runtimeValue;
    public Object getRuntimeValue() {
        return runtimeValue;
    }

    public void setRuntimeValue(Object runtimeValue) {
        this.runtimeValue = runtimeValue;
    }


    protected abstract ParseTypeEnum support();

    /**
     * 该因子的条件表达式内容
     * @return
     */
    public abstract String buildAttributeCondition();

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
