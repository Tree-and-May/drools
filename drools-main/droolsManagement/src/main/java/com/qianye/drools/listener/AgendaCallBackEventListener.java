/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.qianye.drools.listener;

import com.qianye.drools.service.impl.action.HttpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.springframework.stereotype.Service;

/**
 */
@Slf4j
@Service
public class AgendaCallBackEventListener implements AgendaEventListener {
    private static final String clientUrl = "https://baidu.com";

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        // 规则匹配前回调方法
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        // 规则匹配后回调方法
        Object result = event.getMatch().getObjects().toArray()[0]; // 获取规则执行结果
        log.info("================MyAgendaEventListener=========== get drools execute result:{}",result);
        // 将结果回调给调用方，例如通过消息队列、REST API等方式
        executeClientCallback(clientUrl);
    }

    @Override
    public void agendaGroupPopped(AgendaGroupPoppedEvent agendaGroupPoppedEvent) {

    }

    @Override
    public void agendaGroupPushed(AgendaGroupPushedEvent agendaGroupPushedEvent) {

    }

    @Override
    public void matchCreated(MatchCreatedEvent event) {
        // 规则匹配创建回调方法
    }

    @Override
    public void matchCancelled(MatchCancelledEvent event) {
        // 规则匹配取消回调方法
    }

    @Override
    public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        // RuleFlowGroup激活前回调方法
    }

    @Override
    public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        // RuleFlowGroup激活后回调方法
    }

    @Override
    public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        // RuleFlowGroup停用前回调方法
    }

    @Override
    public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        // RuleFlowGroup停用后回调方法
    }

    /**
     * 执行通知客户端, 此处以get请求作为示例，实际开发中建议post
     * @param url
     */
    private void executeClientCallback(String url) {
        HttpGet request = new HttpGet(url);
        //HttpPost post=new HttpPost();
        //post.setHeader("Content-Type", "application/json");
        //post.setURI(URI.create(url));

        // 执行HTTP请求
        try {
            String responseBody = HttpService.executeHttpRequest(request);
            log.info("call back client result:{}", responseBody);
        } catch (Exception e) {
            log.error("HTTP request failed {}", e);
        }

    }
}