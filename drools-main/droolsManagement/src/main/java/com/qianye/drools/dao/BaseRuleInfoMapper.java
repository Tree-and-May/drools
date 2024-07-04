package com.qianye.drools.dao;


import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleInfo;
import com.qianye.drools.model.BaseRulePropertyInfo;
import com.qianye.drools.model.BaseRulePropertyRelInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleInfoMapper {


    /**
     * 方法说明：新增规则信息
     * @param baseRuleInfo
     * @return
     */
    void insertRuleInfo(BaseRuleInfo baseRuleInfo);



    /**
     *
     * 方法说明: 查询规则信息集合
     * @param baseRuleInfo 参数
     */
    List<BaseRuleInfo> findBaseRuleInfoList(BaseRuleInfo baseRuleInfo);

    /**
     *
     * 方法说明: 查询规则属性信息
     * @param baseRulePropertyInfo 参数
     */
    List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo);

    /**
     * 方法说明: 根据规则获取已经配置的属性信息
     * @param ruleId 参数
     */
    List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(@Param("ruleId") Long ruleId);

    /**
     *
     * 方法说明: 根据场景获取对应的规则规则信息
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
