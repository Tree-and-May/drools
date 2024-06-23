package com.qianye.drools.controller;


import com.qianye.drools.common.R;
import com.qianye.drools.model.*;
import com.qianye.drools.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
public class RuleController {

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


    // 新增的操作应该放在 管理态
    @PostMapping("/insertRules")
    public R insertRuleInfo(@RequestBody InsertRuleInfo insertRuleInfo){
        // 1. 新增规则，返回rule_id
        BaseRuleInfo baseRuleInfo = new BaseRuleInfo();
        baseRuleInfo.setSceneId(insertRuleInfo.getSceneId());
        baseRuleInfo.setRuleName("Y_test");
        baseRuleInfo.setRuleDesc("Y_test_desc");
        baseRuleInfo.setRuleEnabled(1);
        R<Long> ruleResult = ruleInfoService.insertRuleInfo(baseRuleInfo);
        Long ruleId = ruleResult.getData(); //rule_id

        // 2. 新增条件
        BaseRuleConditionInfo baseRuleConditionInfo = insertRuleInfo.getBaseRuleConditionInfo();
        baseRuleConditionInfo.setRuleId(ruleId);
        ruleConditionService.insertRuleConditionInfo(baseRuleConditionInfo);

        // 3. 新增动作
        // rule_action_param_info
        BaseRuleActionParamInfo baseRuleActionParamInfo = insertRuleInfo.getBaseRuleActionParamInfo();
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
        baseRuleActionParamValueInfo.setParamValue(insertRuleInfo.getParamValue());
        ruleActionParamValueService.insertRuleActionParamValue(baseRuleActionParamValueInfo);


        return null;
    }

}
