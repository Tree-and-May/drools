package com.qianye.drools.service;


import com.qianye.drools.common.R;
import com.qianye.drools.model.RuleInfo;

/**
 * 描述：Rule相关业务处理逻辑
 *
 */
public interface RuleService {

    /**
     * 方法说明：新增规则信息
     * @param ruleInfo
     * @return
     */
    R<String> insertRuleInfo(RuleInfo ruleInfo);
}
