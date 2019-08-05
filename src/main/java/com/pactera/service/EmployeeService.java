package com.pactera.service;

import com.pactera.domain.EmployeeLack;

import java.util.List;

/**
 * Created by liguizhen on 2018/9/4 0004.
 */
public interface EmployeeService {

    /**
     * 查询所有的用户
     */
    public List<EmployeeLack> findEmployee();

}
