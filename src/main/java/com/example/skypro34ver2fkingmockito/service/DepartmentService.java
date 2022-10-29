package com.example.skypro34ver2fkingmockito.service;

import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import com.example.skypro34ver2fkingmockito.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> sortEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
