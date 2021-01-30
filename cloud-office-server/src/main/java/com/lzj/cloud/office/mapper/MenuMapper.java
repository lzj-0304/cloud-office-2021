package com.lzj.cloud.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzj.cloud.office.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 老李
 * @since 2021-01-28
 */
public interface MenuMapper extends BaseMapper<Menu> {


    List<Menu> getMenusByAdminId(Integer adminId);
}
