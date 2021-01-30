package com.lzj.cloud.office.controller;


import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.service.IAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老李
 * @since 2021-01-29
 */
/*@RestController
@RequestMapping("/admin")*/
public class AdminController {

    @Resource
    private IAdminService adminService;

    @GetMapping("/{id}")
    public RespBean getAdminById(@PathVariable Integer id){
        return RespBean.success("success",adminService.getById(id));
    }

}
