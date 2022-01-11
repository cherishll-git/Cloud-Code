package com.lyq.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * java代码的方式配置Feign日志
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
