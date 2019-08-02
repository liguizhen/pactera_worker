package com.pactera.service.impl;

import com.pactera.domain.Employee;
import com.pactera.mapper.EmployeeMapper;
import com.pactera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	public List<Employee> findEmployee() {
		List<Employee> list = employeeMapper.findEmployee();
		return list;
	}




}
