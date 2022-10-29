package com.example.skypro34ver2fkingmockito;

import com.example.skypro34ver2fkingmockito.exception.EmployeeAlreadyAddException;
import com.example.skypro34ver2fkingmockito.exception.EmployeeStorageIsFullException;
import com.example.skypro34ver2fkingmockito.exception.IncorrectParamException;
import com.example.skypro34ver2fkingmockito.service.ValidatorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.skypro34ver2fkingmockito.exception.EmployeeNotFoundException;
import com.example.skypro34ver2fkingmockito.model.Employee;
import com.example.skypro34ver2fkingmockito.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static com.example.skypro34ver2fkingmockito.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService(new ValidatorService());

    @AfterEach
    public void afterEach() {
        employeeService.getAll()
                .forEach(employee -> employeeService.removeEmployee(employee.getName(),
                        employee.getSurname(),
                        employee.getSalary(),
                        employee.getDepartmentId()));
    }


    /**
     * addEmployeeTests
     */
    @Test
    public void shouldAddEmployeeCorrectly() {
        Employee expected = employeeService.addEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        assertEquals(expected, employee1);
    }

    @Test
    public void shouldAddEmployeeCorrectly2() {
        assertThat(employeeService.getAll()).isEmpty();

        employeeService.addEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        assertThat(employeeService.getAll())
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(employee1);
    }

    @Test
    public void shouldAddEmployeeWithDoubleSurnameCorrectly() {
        Employee expected = employeeService.addEmployee(employee5DoubleSurname.getName(),
                employee5DoubleSurname.getSurname(),
                employee5DoubleSurname.getSalary(),
                employee5DoubleSurname.getDepartmentId());

        assertEquals(expected, employee5DoubleSurname);
    }

    @Test
    public void shouldAddEmployeeWithDoubleNameCorrectly() {
        Employee expected = employeeService.addEmployee(employee5DoubleName.getName(),
                employee5DoubleName.getSurname(),
                employee5DoubleName.getSalary(),
                employee5DoubleName.getDepartmentId());

        assertEquals(expected, employee5DoubleName);
    }

    @Test
    public void shouldAddEmployeeWithCapitalizeLettersCorrectly() {
        Employee expected = employeeService.addEmployee(employee1WithCapitalLetters.getName(),
                employee1WithCapitalLetters.getSurname(),
                employee1WithCapitalLetters.getSalary(),
                employee1WithCapitalLetters.getDepartmentId());

        assertEquals(expected, employee1);
    }

    @Test
    public void shouldAddEmployeeWithLowCaseLettersCorrectly() {
        Employee expected = employeeService.addEmployee(employee1WithLowCaseLetters.getName(),
                employee1WithLowCaseLetters.getSurname(),
                employee1WithLowCaseLetters.getSalary(),
                employee1WithLowCaseLetters.getDepartmentId());

        assertEquals(expected, employee1);
    }

    @Test
    public void shouldReturnEmployeeStorageIsFullException() {
        List<Character> letters = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            letters.add(i);
        }

        for (int i = 0; i < EmployeeService.getSize(); i++) {
            employeeService.addEmployee(employee1.getName().replace('r', letters.get(i)),
                    employee1.getSurname(), employee1.getSalary(), employee1.getDepartmentId());
        }

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee(employee1.getName(),
                        employee1.getSurname(),
                        employee1.getSalary(),
                        employee1.getDepartmentId()));
    }

    @Test
    public void shouldReturnEmployeeAlreadyAddException() {
        employeeService.addEmployee(employee1.getName(), employee1.getSurname(),
                employee1.getSalary(), employee1.getDepartmentId());
        assertThrows(EmployeeAlreadyAddException.class,
                () -> employeeService.addEmployee(employee1.getName(),
                        employee1.getSurname(),
                        employee1.getSalary(),
                        employee1.getDepartmentId()));
    }


    /**
     * removeEmployeeTests
     */

    @Test
    public void shouldRemoveEmployeeCorrectly() {
        employeeService.addEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        employeeService.removeEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        assertThat(employeeService.getAll()).isEmpty();


    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionUsingRemoveEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(employee1.getName(),
                        employee1.getSurname(),
                        employee1.getSalary(),
                        employee1.getDepartmentId()));
    }

    /**
     * findEmployeeTests
     */

    @Test
    public void shouldFindEmployeeCorrectly() {
        employeeService.addEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        employeeService.findEmployee(employee1.getName(),
                employee1.getSurname(),
                employee1.getSalary(),
                employee1.getDepartmentId());

        assertThat(employeeService.getAll()).containsExactly(employee1);
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionUsingFindEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(employee1.getName(),
                        employee1.getSurname(),
                        employee1.getSalary(),
                        employee1.getDepartmentId()));
    }

    /**
     * incorrectParameters
     */

    @Test
    public void shouldReturnEmployeeIncorrectParamException() {
        assertThrows(IncorrectParamException.class,
                () -> employeeService.addEmployee(employee1IncorrectSymbols.getName(),
                        employee1IncorrectSymbols.getSurname(),
                        employee1IncorrectSymbols.getSalary(),
                        employee1IncorrectSymbols.getDepartmentId()));
    }


}
