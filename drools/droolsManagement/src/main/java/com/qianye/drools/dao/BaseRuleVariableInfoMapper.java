package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleVariableInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleVariableInfoMapper
 * VERSION:   1.0
 */
public interface BaseRuleVariableInfoMapper {

    /**
     *
     * 方法说明: 根据变量类型或数值类型查询变量信息
     * @param baseRuleVariableInfo 参数
     */
    List<BaseRuleVariableInfo> findBaseRuleVariableInfoList(BaseRuleVariableInfo baseRuleVariableInfo);
}
