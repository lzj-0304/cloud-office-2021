package com.lzj.cloud.office.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzj.cloud.office.pojo.User;
import com.lzj.cloud.office.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@RestController
public class UserController {
    @Resource
    private IUserService userService;


    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable Integer id){
        return userService.queryUserById(id);
    }

    @GetMapping("user/userName/{userName}")
    public User queryUserById(@PathVariable String  userName){
        return userService.queryUserByUserName(userName);
    }


    @GetMapping("user/list")
    public IPage<User> queryUserByParams(@RequestParam(defaultValue = "1") Integer paheNum, @RequestParam(defaultValue = "10") Integer pageSize, String userName) {
        return userService.selectForPage(new Page<User>(paheNum,pageSize),userName);
    }
}
