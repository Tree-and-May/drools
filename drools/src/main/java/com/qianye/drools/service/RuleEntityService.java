package com.qianye.drools.service;

import com.qianye.drools.model.BaseRuleEntityInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: RuleEntityService
 * VERSION:   1.0
 */
public interface RuleEntityService {

    /**
     * <p>
     * 方法说明: 获取规则引擎实体信息
     *
     * @param baseRuleEntityInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityInfoList(BaseRuleEntityInfo baseRuleEntityInfo);

    /**
     * <p>
     * 方法说明: 根据实体id获取实体信息
     *
     * @param id 实体id
     */
    BaseRuleEntityInfo findBaseRuleEntityInfoById(final Long id);
}
