package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleEntityInfo;
import com.qianye.drools.model.BaseRuleSceneEntityRelInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleSceneEntityRelInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleSceneEntityRelInfoMapper {

    /**
     *
     * 方法说明: 查询场景与实体关系表信息
     * @param baseRuleSceneEntityRelInfo 参数
     */
    List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo);


    /**
     *
     * 方法说明: 根据场景信息获取相关的实体信息
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
