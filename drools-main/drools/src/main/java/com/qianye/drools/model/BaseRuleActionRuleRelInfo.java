package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：动作与规则信息关系
 * CLASSPATH: com.sky.lli.model.BaseRuleActionRuleRelInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionRuleRelInfo extends BaseModel {
    private Long ruleActionRelId;//主键
    private Long actionId;//动作
    private Long ruleId;//规则
}
