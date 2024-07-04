package com.qianye.drools.attribute.parser.expression;

import lombok.Getter;

/**
 * 集合表达式
 */
public enum CollectionExpressionEnum {
    CONTAINS("contains"),

    NOT_CONTAINS("not contains");
    @Getter
    private String expression;



    CollectionExpressionEnum(String expression){
        this.expression=expression;
    }
}
