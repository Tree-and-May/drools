package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.dao.BaseRuleActionRuleRelInfoMapper;
import com.qianye.drools.model.BaseRuleActionParamInfo;
import com.qianye.drools.model.BaseRuleActionRuleRelInfo;
import com.qianye.drools.service.RuleActionRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionRelServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleActionRelServiceImpl implements RuleActionRelService {

    @Resource
    private BaseRuleActionRuleRelInfoMapper baseRuleActionRuleRelInfoMapper;


    /**
     * 新增规则和动作关系
     * @param baseRuleActionRuleRelInfo
     * @return
     */
    @Override
    public R<Long> insertRuleActionRel(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo) {
        // 新增
        baseRuleActionRuleRelInfoMapper.insertRuleActionRel(baseRuleActionRuleRelInfo);
        // 查找id
        List<BaseRuleActionRuleRelInfo> list = baseRuleActionRuleRelInfoMapper.findBaseRuleActionRuleRelInfoList(baseRuleActionRuleRelInfo);
        Long latestId = -1l;
        for(BaseRuleActionRuleRelInfo b : list){
            latestId = b.getRuleActionRelId();
        }
        return R.success(latestId);

    }

    /**
     * <p>
     * 方法说明: 获取规则与动作关系集合信息
     *
     * @param baseRuleActionRuleRelInfo 参数
     * @param page                      分页参数
     */
    @Override
    public PageInfo<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoPage(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionRuleRelInfo> list = this.baseRuleActionRuleRelInfoMapper.findBaseRuleActionRuleRelInfoList(baseRuleActionRuleRelInfo);
        return new PageInfo<>(list);
    }
}
