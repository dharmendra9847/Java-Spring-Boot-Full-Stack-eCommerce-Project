package com.spring.autowire.autowirebyconstructor;

public class Car {
    private SpecificationByConstructor specificationByConstructor;

    public Car(SpecificationByConstructor specificationByConstructor) {
        this.specificationByConstructor = specificationByConstructor;
    }

    public void displayDetails() {
        System.out.println(specificationByConstructor);
    }
}
