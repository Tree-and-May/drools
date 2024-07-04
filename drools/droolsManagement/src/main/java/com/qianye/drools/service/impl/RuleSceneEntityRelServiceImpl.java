package com.qianye.drools.service.impl;

import com.github.pagehelper.PageInfo;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleEntityInfo;
import com.qianye.drools.model.BaseRuleSceneEntityRelInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;
import com.qianye.drools.dao.BaseRuleSceneEntityRelInfoMapper;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.service.RuleSceneEntityRelService;
import com.qianye.drools.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleSceneEntityRelServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleSceneEntityRelServiceImpl implements RuleSceneEntityRelService {

    @Resource
    private BaseRuleSceneEntityRelInfoMapper baseRuleSceneEntityRelInfoMapper;


    /**
     * <p>
     * 方法说明: 查询场景与实体关系表信息
     *
     * @param baseRuleSceneEntityRelInfo 参数
     * @param page                       分页参数
     */
    @Override
    public List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo, PageInfo page) {
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleSceneEntityRelInfoList(baseRuleSceneEntityRelInfo);
    }

    /**
     * <p>
     * 方法说明: 根据场景信息获取相关的实体信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo)  {
        //判断参数
        if (null == baseRuleSceneInfo || (StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()) &&
                null == baseRuleSceneInfo.getSceneId())) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        //查询数据
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleEntityListByScene(baseRuleSceneInfo);
    }
}
