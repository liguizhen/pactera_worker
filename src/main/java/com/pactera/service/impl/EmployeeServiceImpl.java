package com.pactera.service.impl;

import com.pactera.domain.Employee;
import com.pactera.domain.EmployeeLack;
import com.pactera.mapper.EmployeeMapper;
import com.pactera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<EmployeeLack> findEmployee() {
		List<EmployeeLack> employeeLackList = new ArrayList<>();
		List<Employee> list = employeeMapper.findEmployee();
		if(list != null && list.size() > 0){
			for(Employee employee:list){
				EmployeeLack employeeLack = new EmployeeLack();
				employeeLack.setEmployee(employee.getEmployee());
				employeeLack.setTotal(employee.getTotal());
				List<String> dateList = employeeMapper.findLackDate(employee.getEmployee());
				String lackDate = listToString(dateList, ", ");
				employeeLack.setLackDate(lackDate);
				employeeLackList.add(employeeLack);
 			}
		}
		return employeeLackList;
	}

	private String listToString(List list, String separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 2);
	}


}
