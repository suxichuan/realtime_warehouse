package com.cque.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:31:10
 */
@Configuration
public class PoolConifg {
    @Bean
    public ThreadPoolTaskExecutor getPoolExecutor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);    //线程数
        threadPoolTaskExecutor.setQueueCapacity(10000);    //等待队列容量 ，线程数不够任务会等待
        threadPoolTaskExecutor.setMaxPoolSize(10);     // 最大线程数，等待数不够会增加线程数，直到达此上线  超过这个范围会抛异常
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;

    }
}
