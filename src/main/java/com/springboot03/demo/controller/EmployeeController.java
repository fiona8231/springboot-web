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

    @Autowired
    DepartmentDao departmentDao;

    //direct to list page
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("myemps", employees);

        return "emp/list";
    }

    //forward to addingpage
    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //add employee
    @PostMapping("/emp")
    public String addEmp(Employee employee){

      employeeDao.save(employee);

      //点击add后，来到list页面
      //不能返回到模板引擎，需要重定向
      return "redirect:/emps";
    }

    //来到修改页面，先查出当前员工，然后回显
    @GetMapping("/emp/{id}")
    public String EditPage(@PathVariable("id") Integer id, Model model){
       Employee e = employeeDao.get(id);
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("e", e);
        model.addAttribute("depts", depts);

       //回到【添加】页面，添加页面和修改公用一个
       // employeeDao.save(e);
        return "/emp/add";
    }
    @PutMapping("/emp")
    public String modify(Employee e){
         employeeDao.save(e);
         return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer myid){
            employeeDao.delete(myid);
            return "redirect:/emps";
    }



}
