package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication将三个有用的注解组合在了一起
 * 
 * @Configaration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
@SpringBootApplication
/**
 * mybatis-plus时注入mapper失败的问题
 */
@MapperScan(value = "com.vision")
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
