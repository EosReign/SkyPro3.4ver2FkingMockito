package com.example.skypro34ver2fkingmockito.service;

import org.springframework.stereotype.Service;
import com.example.skypro34ver2fkingmockito.exception.EmployeeInvalidInputException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import com.example.skypro34ver2fkingmockito.model.Employee;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    protected List<Employee> arr = new ArrayList<>();

    public Employee employeeAdd(String name, String surname, int department) {
        validatorData(name, surname, department);
        Employee employee = new Employee(name, surname, department);
        validatorIsContains(employee);
        arr.add(employee);
        return employee;
    }

    public Employee employeeFind(String name, String surname, int department) {
        validatorData(name, surname, department);
        Employee employee = new Employee(name, surname, department);
        validatorIsContains(employee);
        employee.setIndex(arr.lastIndexOf(employee));
        return employee;
    }

    public Employee employeeRemove(String name, String surname, int department) {
        validatorData(name, surname, department);
        Employee employee = new Employee(name, surname, department);
        validatorIsContains(employee);
        arr.remove(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(arr);
    }

    private void validatorData(String name, String surname, int department) throws EmployeeInvalidInputException {
        if (name == null || surname == null || department == ' ') {
            throw new EmployeeInvalidInputException();
        }
    }

    private void validatorIsContains(Employee employee) throws EmployeeNotFoundException {
        if (!arr.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
    }

}
