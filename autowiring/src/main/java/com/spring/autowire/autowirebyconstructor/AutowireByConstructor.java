package com.spring.autowire.autowirebyconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByConstructor {

    public static void main(String[] args) {

        /* Autowiring by Name */
        ApplicationContext context = new ClassPathXmlApplicationContext("autowireByConstructor.xml");
        Car car = (Car) context.getBean("myCar");
        car.displayDetails();
    }
}
