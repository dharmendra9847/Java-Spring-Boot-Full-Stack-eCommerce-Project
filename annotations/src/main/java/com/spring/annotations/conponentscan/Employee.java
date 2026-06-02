package com.spring.annotations.conponentscan;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeEmailAddress;
    private double salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" +
                "Employee Details:\n" +
                "-----------------------------------\n" +
                "ID            : " + employeeId + "\n" +
                "Name          : " + employeeName + "\n" +
                "Email         : " + employeeEmailAddress + "\n" +
                "Salary        : $" + salary + "\n" +
                "-----------------------------------";
    }
}
