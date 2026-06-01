package com.spring.challenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCMainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserManager userManagerDataProvider = (UserManager) context.getBean("userManagerDataProvider");
        System.out.println("User Details : " + userManagerDataProvider.getUserInfo());

        UserManager userManagerNewDataProvider = (UserManager) context.getBean("userManagerNewDataProvider");
        System.out.println("User Details : " + userManagerNewDataProvider.getUserInfo());

        UserManager userManagerWebServiceDataProvider = (UserManager) context.getBean("userManagerWebServiceDataProvider");
        System.out.println("User Details : " + userManagerWebServiceDataProvider.getUserInfo());

    }
}
