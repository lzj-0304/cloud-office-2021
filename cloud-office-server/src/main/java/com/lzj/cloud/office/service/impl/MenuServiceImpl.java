package com.lzj.cloud.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzj.cloud.office.mapper.MenuMapper;
import com.lzj.cloud.office.pojo.Menu;
import com.lzj.cloud.office.service.IMenuService;
import com.lzj.cloud.office.utils.AdminUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老李
 * @since 2021-01-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        //如果为空，去数据库获取
        return  this.baseMapper.getMenusByAdminId(adminId);
    }
}
