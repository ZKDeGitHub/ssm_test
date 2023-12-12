package com.javasm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author: zk
 * @description: spring与mvc集成，配置返回值的jsp所在位置
 * @date: 2023/12/10 14:58
 * @version: 1.0
 */
@Configuration
@EnableWebMvc //相当于处理器映射器与处理器适配器的配置
public class SpringMvcConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
