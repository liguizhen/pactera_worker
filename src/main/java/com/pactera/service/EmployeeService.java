package com.pactera.service;

import com.pactera.domain.Employee;

import java.util.List;

/**
 * Created by liguizhen on 2018/9/4 0004.
 */
public interface EmployeeService {

    /**
     * 查询所有的用户
     */
    public List<Employee> findEmployee();

}
