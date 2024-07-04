package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleConditionInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleConditionService
 * VERSION:   1.0
 */
public interface RuleConditionService {

    /**
     *方法说明：新增条件信息
     * @param baseRuleConditionInfo
     * @return
     */
    R<String> insertRuleConditionInfo(BaseRuleConditionInfo baseRuleConditionInfo);




    /**
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page);

    /**
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(final Long ruleId);
}
