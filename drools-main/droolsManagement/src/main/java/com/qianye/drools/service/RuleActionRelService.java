package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleActionParamInfo;
import com.qianye.drools.model.BaseRuleActionRuleRelInfo;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionRelService
 * VERSION:   1.0
 */
public interface RuleActionRelService {

    /**
     * 新增规则与动作关系
     * @param baseRuleActionRuleRelInfo
     * @return
     */
    R<Long> insertRuleActionRel(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo);

    /**
     *
     * 方法说明: 获取规则与动作关系集合信息
     * @param baseRuleActionRuleRelInfo 参数
     * @param page 分页参数
     */
    PageInfo<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoPage(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo, PageInfo page);
}
