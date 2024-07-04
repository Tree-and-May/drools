package com.qianye.drools.attribute.parser.expression;

import lombok.Getter;

public enum StringExpressionEnum {
    EQUAL("=="),
    NOT_EQUAL("!="),
    LARGER_THAN(">"),
    LARGER_EQUAL(">="),
    LITTLE_THAN("<"),
    LITTLE_EQUAL("<="),
    START_WITH(".startWith"),
    END_WITH(".endWith");
    @Getter
    private String expression;



    StringExpressionEnum(String expression){
        this.expression=expression;
    }
}
