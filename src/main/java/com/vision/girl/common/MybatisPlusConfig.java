package com.vision.girl.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * Mybatis-plus 插件配置类
 * 
 * @author Jack_Road
 * @date 2019/9/4 15:09
 */
@Configuration
@MapperScan(basePackages = "com.vision.girl.*.mapper*")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制
        paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }
}
