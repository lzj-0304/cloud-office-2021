package com.lzj.cloud.office.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@RestController
@Api(tags = "环境测试")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
