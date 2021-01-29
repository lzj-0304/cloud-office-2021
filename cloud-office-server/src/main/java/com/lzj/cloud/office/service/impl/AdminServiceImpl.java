package com.lzj.cloud.office.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.pojo.Admin;
import com.lzj.cloud.office.mapper.AdminMapper;
import com.lzj.cloud.office.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老李
 * @since 2021-01-29
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


    /**
     * 简易版用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public RespBean login(String username, String password) {
        if(StringUtils.isBlank(username)){
            return RespBean.error("请输入用户名!");
        }
        if(StringUtils.isBlank(password)){
            return RespBean.error("请输入用户密码!");
        }

        Admin admin = getAdminByUserName(username);
        if (null==admin){
            return RespBean.error("用户记录不存在!");
        }
        /**
         * 比对密码
         */
        if(!(password.equals(admin.getPassword()))){
            return RespBean.error("用户密码错误!");
        }

        if (!admin.getEnabled()){
            return RespBean.error("账号被禁用，请联系管理员！");
        }

        String token =  UUID.randomUUID().toString();
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead","Authorization");
       return RespBean.success("用户登录成功",tokenMap);

    }

    @Override
    public Admin getAdminByUserName(String username) {
        return this.baseMapper.selectOne(new QueryWrapper<Admin>().eq("username",username));
    }
}
