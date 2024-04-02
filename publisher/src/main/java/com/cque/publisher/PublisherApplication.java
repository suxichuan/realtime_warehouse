package com.cque.publisher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2023/03/06:15:33:16
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cque.publisher.mapper")
public class PublisherApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublisherApplication.class,args);
    }
}
