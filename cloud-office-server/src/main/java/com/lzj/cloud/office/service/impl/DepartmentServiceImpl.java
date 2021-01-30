package com.lzj.cloud.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzj.cloud.office.mapper.DepartmentMapper;
import com.lzj.cloud.office.pojo.Department;
import com.lzj.cloud.office.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Override
    public List<Department> getAllDepartments() {
        return this.baseMapper.getAllDepartments(-1);
    }
}
