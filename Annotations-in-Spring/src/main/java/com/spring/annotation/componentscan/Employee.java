package com.spring.annotation.componentscan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {

    @Value("1")
    private int employeeId;

    @Value("John")
    private String employeeName;

    @Value("john.doe@gmail.com")
    private String employeeEmailAddress;

    @Value("50000")
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

    public String displayEmployeeDetails() {
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
