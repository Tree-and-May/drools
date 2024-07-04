package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleActionParamValueInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleActionParamValueInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleActionParamValueInfoMapper {

    /**
     * 新增动作参数值
     * @param baseRuleActionParamValueInfo
     */
    void insertRuleActionParamValue(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo);


    /**
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     */
    List<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoList(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo);


    /**
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(@Param("paramId") Long paramId);
}
