package com.qianye.drools.service;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.model.*;
import com.qianye.drools.ApplicationTests;
import com.qianye.drools.model.fact.RuleExecutionObject;
import com.qianye.drools.model.fact.RuleExecutionResult;
import com.qianye.drools.model.fact.TestRule;
import com.qianye.drools.util.json.JsonSerializeUtil;
import com.qianye.drools.util.spring.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
//单元测试中默认事务会回滚,使用注解 @Rollback(false)取消回滚
@Transactional
@RunWith(JUnit4ClassRunner.class)
public class DroolsTests extends ApplicationTests {

    @Resource
    private RuleEntityService ruleEntityService;
    @Resource
    private RuleEntityItemService ruleEntityItemService;
    @Resource
    private RuleSceneService ruleSceneService;
    @Resource
    private RuleVariableService ruleVariableService;
    @Resource
    private RuleSceneEntityRelService ruleSceneEntityRelService;
    @Resource
    private RuleActionService ruleActionService;
    @Resource
    private RuleActionParamService ruleActionParamService;
    @Resource
    private RuleActionRelService ruleActionRelService;
    @Resource
    private RuleActionParamValueService ruleActionParamValueService;
    @Resource
    private RuleConditionService ruleConditionService;
    @Resource
    private RuleInfoService ruleInfoService;
    @Resource
    private DroolsRuleEngineService droolsRuleEngineService;

    /**
     * <p>
     * 方法说明: 测试规则相关查询
     */
    @Test
    public void findBaseRuleEntityInfiListTest() {
        try {

            //场景集合
            List<BaseRuleSceneInfo> ceneList = this.ruleSceneService.findBaseRuleSceneInfiList(null);
            //场景与实体关系
            List<BaseRuleSceneEntityRelInfo> rellist = this.ruleSceneEntityRelService.findBaseRuleSceneEntityRelInfoList(null, new PageInfo());
            //自定义变量集合
            List<BaseRuleVariableInfo> varList = this.ruleVariableService.findBaseRuleVariableInfoList(null, new PageInfo());
            //实体集合
            List<BaseRuleEntityInfo> list = this.ruleEntityService.findBaseRuleEntityInfoList(null);
            BaseRuleEntityItemInfo entityItemInfo = new BaseRuleEntityItemInfo();
            entityItemInfo.setEntityId(list.get(0).getEntityId());
            //实体属性集合
            List<BaseRuleEntityItemInfo> itenList = this.ruleEntityItemService.findBaseRuleEntityItemInfoList(entityItemInfo);
            //动作集合
            List<BaseRuleActionInfo> acList = this.ruleActionService.findBaseRuleActionInfoPage(null, new PageInfo()).getList();
            //动作与规则关系集合信息
            List<BaseRuleActionRuleRelInfo> ruleActionRelList = this.ruleActionRelService.findBaseRuleActionRuleRelInfoPage(null, new PageInfo()).getList();
            //动作参数集合
            List<BaseRuleActionParamInfo> paramList = this.ruleActionParamService.findBaseRuleActionParamInfoPage(null, new PageInfo()).getList();
            //动作参数值集合
            List<BaseRuleActionParamValueInfo> paramValueList = this.ruleActionParamValueService.findBaseRuleActionParamValueInfoPage(null, new PageInfo()).getList();
            //规则条件集合
            List<BaseRuleConditionInfo> conditionList = this.ruleConditionService.findBaseRuleConditionInfoPage(null, new PageInfo()).getList();
            //规则集合
            List<BaseRuleInfo> ruleList = this.ruleInfoService.findBaseRuleInfoPage(null, new PageInfo()).getList();
            //规则属性集合
            List<BaseRulePropertyInfo> proList = this.ruleInfoService.findBaseRulePropertyInfoList(null);
            //已经配置的属性
            List<BaseRulePropertyRelInfo> allProList = this.ruleInfoService.findRulePropertyListByRuleId(null);

            //上下文获取实例
            DroolsActionService action = SpringContextUtil.getBeanByName("testActionImpl");
            System.out.println(action);

            //打印信息
            System.out.println("==================================================================================================================");
            System.out.println(JsonSerializeUtil.toJson(ceneList));
            System.out.println(JsonSerializeUtil.toJson(rellist));
            System.out.println("==================================================================================================================");
            System.out.println(JsonSerializeUtil.toJson(varList));
            System.out.println("==================================================================================================================");
            System.out.println(JsonSerializeUtil.toJson(list));
            System.out.println("=================================================================================================================");
            System.out.println(JsonSerializeUtil.toJson(itenList));
            System.out.println(JsonSerializeUtil.toJson(acList));
            System.out.println(JsonSerializeUtil.toJson(ruleActionRelList));
            System.out.println(JsonSerializeUtil.toJson(paramList));
            System.out.println(JsonSerializeUtil.toJson(paramValueList));
            System.out.println(JsonSerializeUtil.toJson(conditionList));
            System.out.println(JsonSerializeUtil.toJson(ruleList));
            System.out.println(JsonSerializeUtil.toJson(proList));
            System.out.println(JsonSerializeUtil.toJson(allProList));
            System.out.println("=================================================================================================================");
        } catch (Exception e) {
            log.error("Drool异常:", e);
        }
    }

    /**
     * <p>
     * 方法说明:  测试规则
     * 从库中读取，生成drl文件
     */
    @Test
    public void executeDroolsTest() {
        try {
            // 假装有用户传入fact
            RuleExecutionObject object = new RuleExecutionObject();
            TestRule test = new TestRule(); // 把条件信息导入运行程序（放进object）
            test.setAmount(100);
            test.setScore(20);
            test.setMessage("lihao");
            object.addFactObject(test);
            RuleExecutionResult result = new RuleExecutionResult();
            // ?? 把result作为全局变量
            object.setGlobal("_result", result);
            // 规则引擎执行
            RuleExecutionObject response = this.droolsRuleEngineService.excute(object, "test");
        } catch (Exception e) {
            log.error("Drool异常:", e);
        }
    }

}
