package com.qianye.drools;

import com.qianye.drools.util.spring.SpringContextUtil;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.qianye.drools.dao")
public class Application implements ApplicationRunner{

    //项目启动主方法
    public static void main(String[] args) {
        //项目启动返回上下文
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        //将上下文注入到spring工具类中
        SpringContextUtil.setApplicationContext(applicationContext);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //reload
    }
}