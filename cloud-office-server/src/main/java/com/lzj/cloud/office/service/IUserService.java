package com.lzj.cloud.office.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzj.cloud.office.pojo.User;

/**
 * @description 需要更多资料 请加vx：lezijie007
 *
 * @author 乐字节--老李
 * @version 1.0
 */
public interface IUserService {
    public User queryUserById(Integer id);

    public User queryUserByUserName(String  userName);



    public IPage<User> selectForPage(Page<User> page, String userName);
}
