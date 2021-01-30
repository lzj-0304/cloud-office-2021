package com.lzj.cloud.office.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *乐字节  踏实教育 用心服务
 * @author 乐字节--老李
 * @version 1.0
 */
@SpringBootConfiguration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
