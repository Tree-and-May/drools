package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.model.BaseRuleActionInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionService
 * VERSION:   1.0
 */
public interface RuleActionService {

    /**
     * <p>
     * 方法说明: 获取动作列表
     *
     * @param baseRuleActionInfo 参数
     * @param page               分页信息
     */
    PageInfo<BaseRuleActionInfo> findBaseRuleActionInfoPage(BaseRuleActionInfo baseRuleActionInfo, PageInfo page);

    /**
     * <p>
     * 方法说明: 根据场景获取所有的动作信息
     *
     * @param sceneInfo 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByScene(BaseRuleSceneInfo sceneInfo);


    /**
     * <p>
     * 方法说明: 根据规则id获取动作集合
     *
     * @param ruleId 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByRule(final Long ruleId);

    /**
     * <p>
     * 方法说明: 查询是否有实现类的动作
     *
     * @param ruleId 规则id
     */
    Integer findRuleActionCountByRuleIdAndActionType(final Long ruleId);
}
