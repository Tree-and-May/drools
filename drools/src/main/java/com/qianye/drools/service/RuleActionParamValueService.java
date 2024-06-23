package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleActionParamValueInfo;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionParamValueService
 * VERSION:   1.0
 */
public interface RuleActionParamValueService {

    /**
     * 新增动作参数值信息
     * @param baseRuleActionParamValueInfo
     * @return
     */
    R<Long> insertRuleActionParamValue(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo);


    /**
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     * @param page                         分页参数
     */
    PageInfo<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoPage(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo, PageInfo page);

    /**
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(final Long paramId);
}
