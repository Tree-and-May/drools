package com.qianye.drools.service;


import com.qianye.drools.model.fact.RuleExecutionObject;
import com.qianye.drools.model.fact.RuleExecutionResult;

/**
 * 描述： drools 实现类动作接口
 * CLASSPATH: com.sky.bluesky.service.DroolsActionService
 * VERSION:   1.0
 */
public interface DroolsActionService {

    /**
     * <p>
     * 方法说明: 引擎执行结束,实现类默认执行方法
     *
     * @param fact   参数
     * @param result 结果集
     */
    void execute(RuleExecutionObject fact, RuleExecutionResult result);
}
