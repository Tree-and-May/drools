package com.qianye.drools.dao;

import com.qianye.drools.model.BaseRuleEntityItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.dao.BaseRuleEntityInfoMapper
 * VERSION:   1.0
 */
@Mapper
public interface BaseRuleEntityItemInfoMapper {
    /**
     *
     * 方法说明: 根据实体id获取规则引擎实体属性信息
     * @param baseRuleEntityItemInfo 参数
     */
    List<BaseRuleEntityItemInfo> findBaseRuleEntityItemInfoList(BaseRuleEntityItemInfo baseRuleEntityItemInfo);

    /**
     * <p>
     * 方法说明: 根据id获取对应的属性信息
     *
     * @param id 属性Id
     */
    BaseRuleEntityItemInfo findBaseRuleEntityItemInfoById(@Param("id") Long id);
}
