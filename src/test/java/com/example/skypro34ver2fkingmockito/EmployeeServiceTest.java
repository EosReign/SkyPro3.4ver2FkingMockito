package com.example.skypro34ver2fkingmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.skypro34ver2fkingmockito.exception.EmployeeInvalidInputException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import com.example.skypro34ver2fkingmockito.model.Employee;
import com.example.skypro34ver2fkingmockito.service.EmployeeService;

// обиталище какой-то неработающей срани, я в ахере. Нафига ничего не работает
public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    public void setUp() {
        final Employee actual = new Employee("Name", "Surname", 2);
        employeeService.getAll().add(actual);
    }

    @Test
    public void employeeAddPositiveTest() {
        Employee expected2 = new Employee("Name", "Surname", 2);
        Assertions.assertEquals(expected2, employeeService.employeeAdd(expected2.getName(), expected2.getSurname(), expected2.getDepartment()));
    }

    @Test
    public void employeeAddNegativeTest() {
        Employee expected = new Employee(null, null, ' ');
        Assertions.assertThrows(EmployeeInvalidInputException.class, () -> {
            employeeService.employeeAdd(expected.getName(), expected.getSurname(), expected.getDepartment());
        }, "EmployeeInvalidInputException - alright");
    }

    @Test
    public void employeeFindTest() {
        Employee expected = new Employee("Name", "Surname", 2);
        // в чем прикол? логика по идее должна работать. Но нет.
        Assertions.assertEquals(expected, employeeService.employeeFind(expected.getName(), expected.getSurname(), expected.getDepartment()));

        Employee expected2 = new Employee("Name2", "Surname2", 4);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.employeeFind(expected.getName(), expected.getSurname(), expected.getDepartment());
        }, "EmployeeNotFoundExceptionIsAlright");
    }

    @Test
    public void employeeRemoveTest() {
        Employee expected = new Employee("Name", "Surname", 2);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.employeeRemove(expected.getName(), expected.getSurname(), expected.getDepartment());
        }, "EmployeeNotFoundExceptionIsAlright");

        Assertions.assertEquals(employeeService.employeeRemove(expected.getName(), expected.getSurname(), expected.getDepartment()), expected);

        Employee expected2 = new Employee("Name2", "Surname2", 4);

    }
}
