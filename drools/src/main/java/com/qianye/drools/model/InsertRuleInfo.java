package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InsertRuleInfo {// rule info request
    private Long sceneId;//租户
    private BaseRuleConditionInfo baseRuleConditionInfo;//接收条件信息
    private BaseRuleActionParamInfo baseRuleActionParamInfo;//接收动作信息
    private String paramValue; // 动作参数（表 rule_action_param_value_info中）
}
