package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleActionRuleRelInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleActionRuleRelInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleActionRuleRelInfoMapper {

    /**
     * 方法说明：新增规则与动作关系信息
     * @param baseRuleActionRuleRelInfo
     */
    void insertRuleActionRel(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo);


    /**
     * <p>
     * 方法说明: 获取规则与动作关系集合信息
     *
     * @param baseRuleActionRuleRelInfo 参数
     */
    List<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoList(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo);
}
