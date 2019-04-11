package com.road.demo;

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
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
