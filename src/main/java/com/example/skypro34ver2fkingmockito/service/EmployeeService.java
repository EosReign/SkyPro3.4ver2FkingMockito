package com.example.skypro34ver2fkingmockito.service;

import com.example.skypro34ver2fkingmockito.exception.EmployeeAlreadyAddException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import com.example.skypro34ver2fkingmockito.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {
    private static int size = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidatorService validator;

    public EmployeeService (ValidatorService validator) {
        this.validator = validator;
    }

    public Employee addEmployee(String name, String surname, int salary, int departmentId) {
        Employee newEmployee = new Employee(
                validator.validate(name),
                validator.validate(surname),
                salary,
                departmentId
        );
        if (size <= employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new EmployeeAlreadyAddException();
        }
        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String name, String surname, int salary, int departmentId) {
        Employee newEmployee = new Employee(name, surname, salary, departmentId);
        if (employees.containsKey(newEmployee.getFullName())) {
            System.out.println("Employee " + newEmployee.getFullName() + " is removed.");
            return employees.remove(newEmployee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name, String surname, int salary, int departmentId) {
        Employee newEmployee = new Employee(name, surname, salary, departmentId);
        if (employees.containsKey(newEmployee.getFullName())) {
            System.out.println("Employee " + newEmployee.getFullName() + " found.");
            return newEmployee;
        }

        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    public static int getSize() {
        return size;
    }

}
