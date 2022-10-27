package com.example.skypro34ver2fkingmockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.skypro34ver2fkingmockito.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    public final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      @RequestParam("department") int department) {
        return employeeService.employeeAdd(name, surname, department).toString() + " добавлен в список";
    }

    @GetMapping(path = "find")
    public String find(@RequestParam("name") String name,
                       @RequestParam("surname") String surname,
                       @RequestParam("department") int department) {
        return employeeService.employeeFind(name, surname, department).getIndex() + " индекс сотрудника";
    }


    @GetMapping(path = "remove")
    public String remove(@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("department") int department) {
        return employeeService.employeeRemove(name, surname, department).toString() + " удален из списка";
    }
}
