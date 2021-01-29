package com.lzj.cloud.office.service;

import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 老李
 * @since 2021-01-29
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    RespBean login(String username, String password);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);
}
