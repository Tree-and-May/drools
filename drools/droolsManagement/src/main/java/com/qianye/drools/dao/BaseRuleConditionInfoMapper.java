package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleConditionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleConditionInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleConditionInfoMapper {

    /**
     * 方法说明：新增条件信息
     * @param baseRuleConditionInfo
     */
    void insertRuleConditionInfo(BaseRuleConditionInfo baseRuleConditionInfo);



    /**
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     */
    List<BaseRuleConditionInfo> findBaseRuleConditionInfoList(BaseRuleConditionInfo baseRuleConditionInfo);

    /**
     * <p>
     * 方法说明: 根据规则获取对应的条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(@Param("ruleId") Long ruleId, @Param("relFlag") Integer relFlag);
}
