package com.pactera.controller;

import com.pactera.domain.Employee;
import com.pactera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pl on 2018/9/20
 */
@Controller
@RequestMapping("/api/pactera/")
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("index")
    public ModelAndView index(){
        List<Employee> employeeList =  employeeService.findEmployee();
        return new ModelAndView("/index");
    }

}
