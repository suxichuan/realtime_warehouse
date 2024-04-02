package com.cque.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MallApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MallApplication.class, args);
        MockTask mockTask = context.getBean(MockTask.class);
        mockTask.mainTask();
    }

}
