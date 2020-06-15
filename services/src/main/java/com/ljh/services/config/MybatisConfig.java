package com.ljh.services.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 分页插件
 *
 * @author luojiahui
 * @date 2020/6/12 15:23
 * @description
 */
@Configuration
@MapperScan("com.ljh.services.mapper")
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
