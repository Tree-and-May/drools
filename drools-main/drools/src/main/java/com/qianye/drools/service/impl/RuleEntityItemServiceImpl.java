package com.qianye.drools.service.impl;

import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleEntityItemInfo;
import com.qianye.drools.dao.BaseRuleEntityItemInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.service.RuleEntityItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleEntityItemServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleEntityItemServiceImpl implements RuleEntityItemService {

    @Resource
    private BaseRuleEntityItemInfoMapper baseRuleEntityItemInfoMapper;

    /**
     * <p>
     * 方法说明: 根据实体id获取规则引擎实体属性信息
     *
     * @param baseRuleEntityItemInfo 参数
     */
    @Override
    public List<BaseRuleEntityItemInfo> findBaseRuleEntityItemInfoList(BaseRuleEntityItemInfo baseRuleEntityItemInfo) {
        return this.baseRuleEntityItemInfoMapper.findBaseRuleEntityItemInfoList(baseRuleEntityItemInfo);
    }

    /**
     * <p>
     * 方法说明: 根据id获取对应的属性信息
     *
     * @param id 属性Id
     */
    @Override
    public BaseRuleEntityItemInfo findBaseRuleEntityItemInfoById(Long id) {
        if (null == id) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.baseRuleEntityItemInfoMapper.findBaseRuleEntityItemInfoById(id);
    }
}
