package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleActionInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;
import com.qianye.drools.dao.BaseRuleActionInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.service.RuleActionService;
import com.qianye.drools.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleActionServiceImpl implements RuleActionService {

    @Resource
    private BaseRuleActionInfoMapper baseRuleActionInfoMapper;

    /**
     * <p>
     * 方法说明: 获取动作列表
     *
     * @param baseRuleActionInfo 参数
     * @param page               分页信息
     */
    @Override
    public PageInfo<BaseRuleActionInfo> findBaseRuleActionInfoPage(BaseRuleActionInfo baseRuleActionInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionInfo> list = this.baseRuleActionInfoMapper.findBaseRuleActionInfoList(baseRuleActionInfo);
        return new PageInfo<>(list);
    }

    /**
     * <p>
     * 方法说明: 根据场景获取所有的动作信息
     *
     * @param sceneInfo 参数
     */
    @Override
    public List<BaseRuleActionInfo> findRuleActionListByScene(BaseRuleSceneInfo sceneInfo) {
        if (null == sceneInfo || (null == sceneInfo.getSceneId() &&
                StringUtil.isNullOrNullValue(sceneInfo.getSceneIdentify()))) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionInfoMapper.findRuleActionListByScene(sceneInfo);
    }

    /**
     * <p>
     * 方法说明: 根据规则id获取动作集合
     *
     * @param ruleId 参数
     */
    @Override
    public List<BaseRuleActionInfo> findRuleActionListByRule(final Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }

        return this.baseRuleActionInfoMapper.findRuleActionListByRule(ruleId);
    }

    /**
     * <p>
     * 方法说明: 查询是否有实现类的动作
     *
     * @param ruleId 规则id
     */
    @Override
    public Integer findRuleActionCountByRuleIdAndActionType(Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionInfoMapper.findRuleActionCountByRuleIdAndActionType(ruleId);
    }
}
