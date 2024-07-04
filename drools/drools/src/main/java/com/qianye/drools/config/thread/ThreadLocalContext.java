package com.qianye.drools.config.thread;

public class ThreadLocalContext {
    private static ThreadLocal<String> tenantIdContext = new ThreadLocal<>();

    public static void setTenant(String tenant){ tenantIdContext.set(tenant);}

    public static String getTenant() { return tenantIdContext.get();}

    public static void clearTenant(){ tenantIdContext.remove();}
}

/*
在多线程环境下管理与租户相关的上下文信息。
通常在一个分布式系统中,不同的用户或租户可能会访问同一个应用程序。
为了确保每个用户或租户的数据和操作都是隔离的,我们需要在应用程序的各个层面维护租户的上下文信息。
在这个示例中,ThreadLocalContext 类提供了一种简单的方式来设置、获取和清除当前线程的租户 ID
 */
