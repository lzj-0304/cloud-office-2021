package com.lzj.cloud.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.model.RespPageBean;
import com.lzj.cloud.office.pojo.Employee;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 老李
 * @since 2021-01-28
 */
public interface IEmployeeService extends IService<Employee> {

    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);


    List<Employee> getEmployee(Integer id);

    RespBean addEmp(Employee employee);
}
