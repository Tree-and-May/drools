package com.qianye.drools.service;


import com.qianye.drools.model.fact.RuleExecutionObject;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.DroolsRuleEngineService
 * VERSION:   1.0
 */
public interface DroolsRuleEngineService {

    /**
     * <p>
     * 方法说明: 规则引擎执行方法
     *
     * @param ruleExecutionObject facr对象信息
     * @param scene               场景
     */
    RuleExecutionObject excute(RuleExecutionObject ruleExecutionObject, final String scene);
}
