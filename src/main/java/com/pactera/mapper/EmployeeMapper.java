package com.pactera.mapper;

import com.pactera.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liguizhen on 2018/9/4 0004.
 */
@Mapper
public interface EmployeeMapper {

    List<Employee> findEmployee();

    List<String> findLackDate(String employee);

}

