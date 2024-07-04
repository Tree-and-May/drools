package com.qianye.drools.service.impl;

import com.qianye.drools.common.R;
import com.qianye.drools.model.*;
import com.qianye.drools.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleInfoService ruleInfoService;

    @Autowired
    private RuleConditionService ruleConditionService;

    @Autowired
    private RuleActionParamService ruleActionParamService;

    @Autowired
    private RuleActionRelService ruleActionRelService;

    @Autowired
    private RuleActionParamValueService ruleActionParamValueService;


    /**
     * 方法说明：新增规则信息
     * @param ruleInfo
     * @return
     */
    @Override
    public R<String> insertRuleInfo(RuleInfo ruleInfo) {
        // 1. 新增规则，返回rule_id
        R<String> ruleResult = ruleInfoService.insertRuleInfo(ruleInfo.getBaseRuleInfo());
        Long ruleId = (Long)ruleResult.getMap().get("ruleId");
        Long sceneId = (Long)ruleResult.getMap().get("sceneId");

        // 2. 新增条件
        BaseRuleConditionInfo baseRuleConditionInfo = ruleInfo.getBaseRuleConditionInfo();
        baseRuleConditionInfo.setRuleId(ruleId);
        ruleConditionService.insertRuleConditionInfo(baseRuleConditionInfo);

        // 3. 新增动作
        // rule_action_param_info
        BaseRuleActionParamInfo baseRuleActionParamInfo = ruleInfo.getBaseRuleActionParamInfo();
        R<Long> actionParamResult = ruleActionParamService.insertRuleActionParamInfo(baseRuleActionParamInfo);
        Long actionParamId = actionParamResult.getData(); //action_param_id
        // rule_action_rule_rel
        BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo = new BaseRuleActionRuleRelInfo();
        baseRuleActionRuleRelInfo.setActionId(baseRuleActionParamInfo.getActionId());
        baseRuleActionRuleRelInfo.setRuleId(ruleId);
        R<Long> ruleActionRelResult = ruleActionRelService.insertRuleActionRel(baseRuleActionRuleRelInfo);
        Long ruleActionRelId = ruleActionRelResult.getData(); //rule_action_rel_id
        // rule_action_param_value_info
        BaseRuleActionParamValueInfo baseRuleActionParamValueInfo = new BaseRuleActionParamValueInfo();
        baseRuleActionParamValueInfo.setRuleActionRelId(ruleActionRelId);
        baseRuleActionParamValueInfo.setActionParamId(actionParamId);
        baseRuleActionParamValueInfo.setParamValue(ruleInfo.getParamValue());
        ruleActionParamValueService.insertRuleActionParamValue(baseRuleActionParamValueInfo);


        return R.success("新增规则成功").add("ruleId",ruleId).add("sceneId",sceneId);

    }
}
