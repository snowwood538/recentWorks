package com.a1qa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String secondName;
    @JsonProperty
    private String email;
    @JsonProperty
    private int age;
    @JsonProperty
    private int salary;
    @JsonProperty
    private String department;

    public Employee(String firstName, String secondName, int age, String email, int salary, String department) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && getSalary() == employee.getSalary() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName(), getEmail(), getAge(), getSalary(), getDepartment());
    }
}
