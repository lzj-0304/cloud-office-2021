package com.lzj.cloud.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzj.cloud.office.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 老李
 * @since 2021-01-28
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusByAdminId();
}
