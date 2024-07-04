package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleConditionInfo;
import com.qianye.drools.dao.BaseRuleConditionInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.service.RuleConditionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleConditionServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {

    @Resource
    private BaseRuleConditionInfoMapper baseRuleConditionInfoMapper;


    /**
     * 方法说明：新增条件信息
     * @param baseRuleConditionInfo
     * @return
     */
    @Override
    public R<String> insertRuleConditionInfo(BaseRuleConditionInfo baseRuleConditionInfo) {
        baseRuleConditionInfoMapper.insertRuleConditionInfo(baseRuleConditionInfo);
        return R.success("新增条件成功");
    }

    /**
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    @Override
    public PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleConditionInfo> list = this.baseRuleConditionInfoMapper.findBaseRuleConditionInfoList(baseRuleConditionInfo);
        return new PageInfo<>(list);
    }

    /**
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    @Override
    public List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleConditionInfoMapper.findRuleConditionInfoByRuleId(ruleId, null);
    }
}
