package com.qianye.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianye.drools.common.R;
import com.qianye.drools.dao.BaseRuleInfoMapper;
import com.qianye.drools.exception.ServiceException;
import com.qianye.drools.model.BaseRuleInfo;
import com.qianye.drools.model.BaseRulePropertyInfo;
import com.qianye.drools.model.BaseRulePropertyRelInfo;
import com.qianye.drools.model.BaseRuleSceneInfo;
import com.qianye.drools.exception.ExceptionEnum;
import com.qianye.drools.service.RuleInfoService;
import com.qianye.drools.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleInfoServiceImpl
 * VERSION:   1.0
 */
@Service
public class RuleInfoServiceImpl implements RuleInfoService {

    @Resource
    private BaseRuleInfoMapper baseRuleInfoMapper;


    /**
     * 方法说明：新增规则信息
     * @param baseRuleInfo
     * @return
     */
    @Override
    public R<String> insertRuleInfo(BaseRuleInfo baseRuleInfo) {
        // 新增insert
        baseRuleInfoMapper.insertRuleInfo(baseRuleInfo);
        // 查找并返回 id 和 sceneId
        List<BaseRuleInfo> list = baseRuleInfoMapper.findBaseRuleInfoList(baseRuleInfo);
        Long latestId = -1L;
        Long latestSceneId = -1L;
        for(BaseRuleInfo b : list){
            latestId = b.getRuleId();
            latestSceneId = b.getSceneId();
        }
        return R.success("新增规则成功").add("ruleId",latestId).add("sceneId",latestSceneId);
    }

    /**
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    @Override
    public PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BaseRuleInfo> list = this.baseRuleInfoMapper.findBaseRuleInfoList(baseRuleInfo);
        return new PageInfo<>(list);
    }

    /**
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    @Override
    public List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo) {
        return this.baseRuleInfoMapper.findBaseRulePropertyInfoList(baseRulePropertyInfo);
    }

    /**
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    @Override
    public List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId) {
        return this.baseRuleInfoMapper.findRulePropertyListByRuleId(ruleId);
    }

    /**
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo) {
        if (null == baseRuleSceneInfo || (null == baseRuleSceneInfo.getSceneId() &&
                StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()))) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }

        return this.baseRuleInfoMapper.findBaseRuleListByScene(baseRuleSceneInfo);
    }
}
