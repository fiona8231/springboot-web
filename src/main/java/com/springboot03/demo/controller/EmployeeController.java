package com.springboot03.demo.controller;


import com.springboot03.demo.dao.DepartmentDao;
import com.springboot03.demo.dao.EmployeeDao;
import com.springboot03.demo.entities.Department;
import com.springboot03.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    //direct to list page
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);

        return "emp/list";
    }


}
