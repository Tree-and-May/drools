package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：动作参数对应的属性值信息表
 * （对变量）进行的操作（paramValue）
 * CLASSPATH: com.sky.lli.model.BaseRuleActionParamValueInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionParamValueInfo extends BaseModel {
    private Long actionParamValueId;//主键
    private Long ruleActionRelId;//动作规则关系主键
    private Long actionParamId;//动作参数
    private String paramValue;//参数值
}
