package com.example.skypro34ver2fkingmockito.service;

import org.springframework.stereotype.Service;
import com.example.skypro34ver2fkingmockito.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DepartmentService extends EmployeeService {

    public String getMaxDepartmentSalary(int department) {
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .max(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }

    public String getMinDepartmentSalary(int department) {
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .min(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }


    public String getAllDepartmentEmployee(int department) {
        List<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .collect(Collectors.toList());
        return employee.toString();
    }
}
