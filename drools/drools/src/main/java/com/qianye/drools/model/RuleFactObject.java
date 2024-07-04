package com.qianye.drools.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装规则执行传参对象
 */
public class RuleFactObject {
    // fact 集合
    private List<Object> factOjectList = new ArrayList<>();
    // 是否全部执行（默认全部）
    private boolean executeAll = true;
    // 根据名称过滤要执行的规则
    private String ruleName;
}
