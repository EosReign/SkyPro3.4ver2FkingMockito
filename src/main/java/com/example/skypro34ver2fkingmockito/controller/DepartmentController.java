package com.example.skypro34ver2fkingmockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.skypro34ver2fkingmockito.service.DepartmentService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    public final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/department/max-salary")
    public String maxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getMaxDepartmentSalary(department);
    }

    @GetMapping(path = "/department/min-salary")
    public String minSalary(@RequestParam("departmentId") int department) {
        return departmentService.getMinDepartmentSalary(department);
    }

    @GetMapping(path = "/all")
    public String allDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.getAllDepartmentEmployee(department);
    }
}

