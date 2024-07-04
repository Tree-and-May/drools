package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleInfo;
import com.qianye.drools.model.BaseRulePropertyInfo;
import com.qianye.drools.model.BaseRulePropertyRelInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleInfoService
 * VERSION:   1.0
 */
public interface RuleInfoService {


    /**
     * 方法说明：新增规则信息
     * @param baseRuleInfo
     * @return
     */
    R<String> insertRuleInfo(BaseRuleInfo baseRuleInfo);





    /**
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page);

    /**
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo);

    /**
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId);

    /**
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
