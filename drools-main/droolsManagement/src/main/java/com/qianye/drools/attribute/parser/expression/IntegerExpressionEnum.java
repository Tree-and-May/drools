package com.qianye.drools.attribute.parser.expression;

import lombok.Getter;

public enum IntegerExpressionEnum {
    EQUAL("=="),
    NOT_EQUAL("!="),
    LARGER_THAN(">"),
    LARGER_EQUAL(">="),
    LITTLE_THAN("<"),
    LITTLE_EQUAL("<=");
    @Getter
    private String expression;



    IntegerExpressionEnum(String expression){
        this.expression=expression;
    }
}
