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
@Api(tags = "用户登录")
public class LoginController {
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword());
    }

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }

    /**
     * 客户端清空用户信息 token串
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }

}
