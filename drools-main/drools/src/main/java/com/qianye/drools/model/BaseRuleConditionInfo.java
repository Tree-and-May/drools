package com.qianye.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * 描述：规则条件信息
 * CLASSPATH: com.sky.lli.model.BaseRuleConditionInfo
 * VERSION:   1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleConditionInfo extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionId;//主键
    private Long ruleId;//规则id
    private String conditionName;//条件名称
    private String conditionExpression;//条件表达式
    private String conditionDesc;//条件描述
}
