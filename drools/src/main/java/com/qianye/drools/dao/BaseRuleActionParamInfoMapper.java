package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleActionParamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleActionParamInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleActionParamInfoMapper {

    /**
     * 新增动作参数
     * @param baseRuleActionParamInfo
     */
    void insertRuleActionParamInfo(BaseRuleActionParamInfo baseRuleActionParamInfo);


    /**
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     */
    List<BaseRuleActionParamInfo> findBaseRuleActionParamInfoList(BaseRuleActionParamInfo baseRuleActionParamInfo);

    /**
     *
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(@Param("actionId") Long actionId);
}
