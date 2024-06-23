package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleActionParamInfo;
import com.qianye.drools.dao.BaseRuleActionParamInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.model.BaseRuleInfo;
import com.qianye.drools.service.RuleActionParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionParamServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleActionParamServiceImpl implements RuleActionParamService {

    @Resource
    private BaseRuleActionParamInfoMapper baseRuleActionParamInfoMapper;

    /**
     * 新增动作参数
     * @param baseRuleActionParamInfo
     * @return
     */
    @Override
    public R<Long> insertRuleActionParamInfo(BaseRuleActionParamInfo baseRuleActionParamInfo) {
        // 新增操作
        baseRuleActionParamInfoMapper.insertRuleActionParamInfo(baseRuleActionParamInfo);
        // 查找id
        List<BaseRuleActionParamInfo> list = baseRuleActionParamInfoMapper.findBaseRuleActionParamInfoList(baseRuleActionParamInfo);
        Long latestId = -1l;
        for(BaseRuleActionParamInfo b : list){
            latestId = b.getActionParamId();
        }
        return R.success(latestId);
    }

    /**
     * <p>
     * 方法说明: 获取动作参数信息
     *
     * @param baseRuleActionParamInfo 参数
     * @param page                    分页参数
     */
    @Override
    public PageInfo<BaseRuleActionParamInfo> findBaseRuleActionParamInfoPage(BaseRuleActionParamInfo baseRuleActionParamInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BaseRuleActionParamInfo> list = this.baseRuleActionParamInfoMapper.findBaseRuleActionParamInfoList(baseRuleActionParamInfo);

        return new PageInfo<>(list);
    }

    /**
     * <p>
     * 方法说明: 根据动作id获取动作参数信息
     *
     * @param actionId 参数
     */
    @Override
    public List<BaseRuleActionParamInfo> findRuleActionParamByActionId(Long actionId) {
        if (null == actionId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionParamInfoMapper.findRuleActionParamByActionId(actionId);
    }
}
