package com.qianye.drools.controller;


import com.qianye.drools.common.R;
import com.qianye.drools.model.*;
import com.qianye.drools.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;


    // 新增的操作应该放在 管理态
    @Transactional
    @PostMapping("/insertRules")
    public R insertRuleInfo(@Valid @RequestBody RuleInfo ruleInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return R.error(400,"参数校验异常").add("errors:",bindingResult.getFieldErrors());
        }

        ruleService.insertRuleInfo(ruleInfo);

        return R.success("新增规则成功");
    }

}
