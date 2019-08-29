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
 * @Mybatis 插件注解类
 */
@MapperScan("com.vision.girl.*.mapper")
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
