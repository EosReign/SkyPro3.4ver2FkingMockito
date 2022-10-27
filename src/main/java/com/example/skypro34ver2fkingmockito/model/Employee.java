package com.example.skypro34ver2fkingmockito.model;

import java.util.Objects;

public class Employee {
    private String fullName;
    private String name;
    private String surname;
    private int department;
    private double salary;
    private int index;

    public Employee(String name, String surname, int department, double salary) {
        this.fullName = name + " " + surname;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.index = -1;
    }

    public Employee(String name, String surname, int department) {
        this.fullName = name + " " + surname;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.index = -1;
    }

    public int getIndex() {
        return index;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalaryInfo() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(fullName, employee.fullName) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, name, surname, department, salary);
    }
}


