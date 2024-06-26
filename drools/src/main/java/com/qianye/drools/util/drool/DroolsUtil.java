package com.qianye.drools.util.drool;

import com.qianye.drools.exception.DroolsExceptionEnum;
import com.qianye.drools.listener.AgendaCallBackEventListener;
import com.qianye.drools.exception.UtilsException;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.util.DroolsUtil
 * VERSION:   1.0
 */
public class DroolsUtil {

    private Logger logger = LoggerFactory.getLogger(DroolsUtil.class);

    //KnowledgeBase 缓存(key：场景标识)
    private static Map<String, KieBase> ruleMap = new ConcurrentHashMap<>();

    private DroolsUtil() {
    }

    private static class SingletonHolder {
        static DroolsUtil instance = new DroolsUtil();
    }

    public static DroolsUtil getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * <p>
     * 方法说明:根据规则字符串重新编译规则，并将编译后的KieBase存入缓存
     *
     * @param rule  规则字符串
     * @param scene 场景标识
     */
    public KieSession getDrlSession(final String rule, final String scene) {

        try {
            // 设置时间格式
            System.setProperty("drools.dateformat", "yyyy-MM-dd");
            //为防止规则文件名字重复，此处加上时间戳( 格式：场景标识+时间戳+.drl)
            String ruleFileName = scene + System.currentTimeMillis() + ".drl";

            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kfs = kieServices.newKieFileSystem();
            kfs.write("src/main/resources/com/drools/rules/" + ruleFileName, rule.getBytes("UTF-8"));
            KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
            if (!kieBuilder.getResults().getMessages(Message.Level.ERROR).isEmpty()) {
                logger.error("规则引擎编译错误:{}", kieBuilder.getResults().getMessages());
                throw new UtilsException(DroolsExceptionEnum.DROOLS_INIT_RULE_FAIL_ERROR);
            }
            KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
            KieBase kBase = kieContainer.getKieBase();
            //放入缓存
            ruleMap.put(scene, kBase);
            KieSession kieSession = kBase.newKieSession();
            kieSession.addEventListener(new DebugRuleRuntimeEventListener());
            kieSession.addEventListener(new AgendaCallBackEventListener());
            return kieSession;
        } catch (Exception e) {
            logger.error("规则引擎初始化失败，请查看错误信息:{}", e.getMessage());
            throw new UtilsException(DroolsExceptionEnum.DROOLS_INIT_RULE_FAIL_ERROR);
        }

    }

    /**
     * <p>
     * 方法说明: 加载drl文件(暂不使用)
     *
     * @param filePath 规则文件路径
     * @param scene    场景
     */
    public KieSession getDrlSessionFromDrlFile(final String filePath, final String scene) {

        try {
            // 设置时间格式
            System.setProperty("drools.dateformat", "yyyy-MM-dd");

            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kfs = kieServices.newKieFileSystem();
            Resource resource = kieServices.getResources().newFileSystemResource(filePath);
            resource.setResourceType(ResourceType.DRL);
            kfs.write(resource);
            KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
            if (!kieBuilder.getResults().getMessages(Message.Level.ERROR).isEmpty()) {
                logger.error("规则引擎编译错误:{}", kieBuilder.getResults().getMessages());
                throw new UtilsException(DroolsExceptionEnum.DROOLS_UTIL_INIT_FAIL_ERROR);
            }
            KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
            KieBase kBase = kieContainer.getKieBase();
            //放入缓存
            ruleMap.put(scene, kBase);
            KieSession kieSession = kBase.newKieSession();
            kieSession.addEventListener(new DebugRuleRuntimeEventListener());
            return kieSession;
        } catch (Exception e) {
            logger.error("规则引擎初始化失败，请查看错误信息:{}", e.getMessage());
            throw new UtilsException(DroolsExceptionEnum.DROOLS_UTIL_INIT_FAIL_ERROR);
        }
    }

    /**
     * <p>
     * 方法说明: 根据场景获取缓存中的kbase,然后创建session，如果返回null，则表示缓存中没有
     *
     * @param scene 场景标识
     */
    public KieSession getDrlSessionInCache(final String scene) {
        try {
            KieBase kbase = ruleMap.get(scene);
            if (kbase == null) {
                return null;
            } else {
                return kbase.newKieSession();
            }
        } catch (Exception e) {
            logger.error("获取 KieBase 信息错误:{}", e);
            throw new UtilsException(DroolsExceptionEnum.DROOLS_UTIL_INIT_FAIL_ERROR);
        }
    }

    /**
     * <p>
     * 方法说明:根据规则字符串重新编译规则，验证规则是否正确
     *
     * @param rule 规则字符串
     */
    public Boolean compileRule(final String rule) {

        //为防止规则文件名字重复，此处加上时间戳( 格式：场景标识+时间戳+.drl)
        String ruleFileName = "testRule" + System.currentTimeMillis() + "testRule.drl";

        try {
            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kfs = kieServices.newKieFileSystem();
            kfs.write("src/main/resources/com/drools/rules/" + ruleFileName, rule.getBytes("UTF-8"));
            KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
            if (kieBuilder.getResults().getMessages(Message.Level.ERROR).isEmpty()) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            logger.error("获取 KieBase 信息错误:{}", e);
            throw new UtilsException(DroolsExceptionEnum.DROOLS_UTIL_INIT_FAIL_ERROR);
        }

        return Boolean.FALSE;
    }


    /**
     * <p>
     * 方法说明: 移除对应的规则（供其它部分调用，比如规则的修改和删除）
     *
     * @param key 场景标识
     */
    public static void removeRuleMap(final String key) {
        ruleMap.remove(key);
    }

    /**
     * <p>
     * 方法说明: 清空规则缓存
     */
    public static void clearRuleMap() {
        ruleMap.clear();
    }
}
