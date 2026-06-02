package com.spring.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Manager {

    @Autowired   // Field injection is not recommended
    @Qualifier("employee")
    private Employee employee;

    @Autowired  // Constructor injection is recommended
    public Manager(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\n=== Manager ===\n" + employee.displayEmployeeDetails() +
                '}';
    }
}
