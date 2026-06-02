package com.spring.annotations.conponentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanAnnotation {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("componentScanDemo.xml");
        Employee employee = (Employee) context.getBean("employee");
        System.out.println(employee.displayEmployeeDetails());
    }
}
