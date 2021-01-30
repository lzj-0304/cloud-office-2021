package com.lzj.cloud.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzj.cloud.office.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 老李
 * @since 2021-01-28
 */
public interface DepartmentMapper extends BaseMapper<Department> {


    List<Department> getAllDepartments(int i);
}
