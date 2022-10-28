package com.example.skypro34ver2fkingmockito.controller;

import com.example.skypro34ver2fkingmockito.exception.EmployeeAlreadyAddException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeStorageIsFullException;
import com.example.skypro34ver2fkingmockito.model.Employee;
import org.springframework.web.bind.annotation.*;
import com.example.skypro34ver2fkingmockito.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String showWelcome() {
        return "Welcome!";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname,
                                @RequestParam int salary,
                                @RequestParam int departmentId){
        return employeeService.addEmployee(name, surname,salary,departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                   @RequestParam("lastName") String surname,
                                   @RequestParam int salary,
                                   @RequestParam int departmentId){
        return employeeService.removeEmployee(name, surname,salary,departmentId);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String name,
                                 @RequestParam("lastName") String surname,
                                 @RequestParam int salary,
                                 @RequestParam int departmentId){
        return employeeService.findEmployee(name, surname,salary,departmentId);
    }

    @GetMapping("/size")
    public int getSize(){
        return EmployeeService.getSize();
    }

    @GetMapping("/showEmployees")
    public List<Employee> showEmployees(){
        return employeeService.getAll();
    }

    @ExceptionHandler
    public String handleEmployeeNotFoundException(EmployeeNotFoundException e){
        return "Employee not found.";
    }

    @ExceptionHandler
    public String handleEmployeeAlreadyAddException(EmployeeAlreadyAddException e){
        return "Employee already added.";
    }

    @ExceptionHandler
    public String handleEmployeeStorageIsFullException(EmployeeStorageIsFullException e){
        return "Employee storage is full.Вы не можете добавить сотрудника.";
    }

}
