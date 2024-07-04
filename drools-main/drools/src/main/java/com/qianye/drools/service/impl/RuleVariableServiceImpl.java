package com.qianye.drools.service.impl;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.model.BaseRuleVariableInfo;
import com.qianye.drools.dao.BaseRuleVariableInfoMapper;
import com.qianye.drools.service.RuleVariableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleVariableServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleVariableServiceImpl implements RuleVariableService {

    @Resource
    private BaseRuleVariableInfoMapper baseRuleVariableInfoMapper;

    /**
     * <p>
     * 方法说明: 根据变量类型或数值类型获取变量集合信息
     *
     * @param baseRuleVariableInfo 参数
     * @param pageInfo             分页参数
     */
    @Override
    public List<BaseRuleVariableInfo> findBaseRuleVariableInfoList(BaseRuleVariableInfo baseRuleVariableInfo, PageInfo pageInfo) {
        return this.baseRuleVariableInfoMapper.findBaseRuleVariableInfoList(baseRuleVariableInfo);
    }
}
