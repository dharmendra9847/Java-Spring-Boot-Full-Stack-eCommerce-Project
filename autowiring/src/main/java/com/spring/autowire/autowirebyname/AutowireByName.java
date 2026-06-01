package com.spring.autowire.autowirebyname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByName {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("autowireByName.xml");
        Car car = (Car) context.getBean("myCar");
        car.displayDetails();
    }
}
