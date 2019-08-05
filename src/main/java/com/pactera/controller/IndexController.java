package com.pactera.controller;

import com.pactera.domain.EmployeeLack;
import com.pactera.service.EmployeeService;
import com.pactera.service.WorkService;
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
    @Autowired
    private WorkService workService;

    @RequestMapping("index")
    public ModelAndView index(){
        List<EmployeeLack> list = employeeService.findEmployee();
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("employeeList",list);
        return mv;
    }

    @RequestMapping("import")
    public ModelAndView importWork(){
        workService.importWork();
        List<EmployeeLack> list = employeeService.findEmployee();
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("employeeList",list);
        return mv;
    }

}
