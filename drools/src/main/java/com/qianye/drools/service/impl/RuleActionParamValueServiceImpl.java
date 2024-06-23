package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleActionParamValueInfo;
import com.qianye.drools.dao.BaseRuleActionParamValueInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.model.BaseRuleInfo;
import com.qianye.drools.service.RuleActionParamValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionParamValueServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleActionParamValueServiceImpl implements RuleActionParamValueService {

    @Resource
    private BaseRuleActionParamValueInfoMapper baseRuleActionParamValueInfoMapper;


    /**
     * 新增动作参数值信息
     * @param baseRuleActionParamValueInfo
     * @return
     */
    @Override
    public R<Long> insertRuleActionParamValue(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo) {
        // 新增
        baseRuleActionParamValueInfoMapper.insertRuleActionParamValue(baseRuleActionParamValueInfo);
        // 查找id
        List<BaseRuleActionParamValueInfo> list = baseRuleActionParamValueInfoMapper.findBaseRuleActionParamValueInfoList(baseRuleActionParamValueInfo);
        Long latestId = -1l;
        for(BaseRuleActionParamValueInfo b : list){
            latestId = b.getActionParamValueId();
        }
        return R.success(latestId);

    }

    /**
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     * @param page                         分页参数
     */
    @Override
    public PageInfo<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoPage(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionParamValueInfo> list = this.baseRuleActionParamValueInfoMapper.findBaseRuleActionParamValueInfoList(baseRuleActionParamValueInfo);
        return new PageInfo<>(list);
    }

    /**
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    @Override
    public BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(Long paramId) {
        if (null == paramId) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionParamValueInfoMapper.findRuleParamValueByActionParamId(paramId);
    }
}
