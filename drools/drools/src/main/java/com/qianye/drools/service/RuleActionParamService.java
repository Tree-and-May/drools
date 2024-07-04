package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.model.BaseRuleActionParamInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionParamService
 * VERSION:   1.0
 */
public interface RuleActionParamService {


    /**
     * 新增动作参数
     * @param baseRuleActionParamInfo
     * @return
     */
    R<Long> insertRuleActionParamInfo(BaseRuleActionParamInfo baseRuleActionParamInfo);

    /**
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     * @param page 分页参数
     */
    PageInfo<BaseRuleActionParamInfo> findBaseRuleActionParamInfoPage(BaseRuleActionParamInfo baseRuleActionParamInfo, PageInfo page);

    /**
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(final Long actionId);
}
