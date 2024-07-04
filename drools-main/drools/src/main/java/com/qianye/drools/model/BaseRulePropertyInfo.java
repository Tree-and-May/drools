package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：规则基础属性信息
 * CLASSPATH: com.sky.lli.model.BaseRulePropertyInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRulePropertyInfo extends BaseModel{
    private Long rulePropertyId;//主键
    private String rulePropertyIdentify;//标识
    private String rulePropertyName;//名称
    private String rulePropertyDesc;//描述
    private String defaultValue;//默认值
}
