package com.example.skypro34ver2fkingmockito;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.skypro34ver2fkingmockito.model.Employee;
import com.example.skypro34ver2fkingmockito.service.DepartmentService;
import com.example.skypro34ver2fkingmockito.service.EmployeeService;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void beforeEach() {
        when(employeeService.getAll()).thenReturn(
                Arrays.asList(
                        new Employee("Ivan", "Petrove", 2, 10000),
                        new Employee("Oleg", "Krot", 2, 30000),
                        new Employee("Alina", "Pavlin", 2, 20000),
                        new Employee("Olga", "Perin", 3, 40000),
                        new Employee("Leila", "Mannaya", 3, 50000)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxDepartmentSalaryTestParams")
    public void getMaxDepartmentSalaryTest(int department,
                                          Employee expected) {
        assertThat(departmentService.getMaxDepartmentSalary(department)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getMinDepartmentSalaryTestParams")
    public void getMinDepartmentSalaryTest(int department,
                                           Employee expected) {
        assertThat(departmentService.getMinDepartmentSalary(department)).isEqualTo(expected);
    }

    public static Stream<Arguments> getMaxDepartmentSalaryTestParams() {
        return Stream.of(
                Arguments.of(2, new Employee("Ivan", "Petrove", 2, 10000)),
                Arguments.of(2, new Employee("Oleg", "Krot", 2, 30000))
        );
    }

    public static Stream<Arguments> getMinDepartmentSalaryTest() {
        return Stream.of(
                Arguments.of(2, new Employee("Ivan", "Petrove", 2, 10000)),
                Arguments.of(2, new Employee("Oleg", "Krot", 2, 30000))
        );
    }
// нахер этот ебучий мохито, задолбался я уже. Срань какая-то. я уже неделю эту домашку пытаюсь сделать, а всё равно срань получается.
    







}
