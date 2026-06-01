package com.spring.autowire.autowirebyname;

public class Car {
    private SpecificationByName specificationByName;

    public void setSpecificationByName(SpecificationByName specificationByName) {
        this.specificationByName = specificationByName;
    }

    public void displayDetails() {
        System.out.println(specificationByName);
    }
}
