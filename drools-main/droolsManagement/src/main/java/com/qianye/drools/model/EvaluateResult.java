package com.qianye.drools.model;

import lombok.Data;


/**
 * 规则评估结果
 */
@Data
public class EvaluateResult {

    /**
     * 匹配的规则Code
     */
    private String ruleCode;
    /**
     * 匹配的规则名称
     */
    private String ruleName;
    /**
     * 匹配的规则结果
     */
    private String result;
}
