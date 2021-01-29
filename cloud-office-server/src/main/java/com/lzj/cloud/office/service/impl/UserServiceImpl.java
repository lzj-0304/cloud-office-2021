package com.lzj.cloud.office.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzj.cloud.office.mapper.UserMapper;
import com.lzj.cloud.office.pojo.User;
import com.lzj.cloud.office.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Override
    public User queryUserById(Integer id) {
        return getById(id);
    }

    @Override
    public User queryUserByUserName(String userName) {
        return getOne(new QueryWrapper<User>().eq("user_name",userName));
    }


    @Override
    public IPage<User> selectForPage(Page<User> page, String userName) {
        return baseMapper.selectForPage(page,userName);
    }


}
