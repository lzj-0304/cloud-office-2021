package com.lzj.cloud.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.lzj.cloud.office.mapper")
@EnableScheduling
public class CloudOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOfficeApplication.class,args);
    }
}
