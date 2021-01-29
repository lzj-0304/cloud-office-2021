package com.lzj.cloud.office.controller;

import com.lzj.cloud.office.model.AdminLoginParam;
import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.pojo.Admin;
import com.lzj.cloud.office.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;

    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword());
    }


}
