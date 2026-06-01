package com.spring.autowire.autowirebytype;

public class Car {
    private SpecificationByType specificationByType;

    public void setSpecificationByType(SpecificationByType specificationByType) {
        this.specificationByType = specificationByType;
    }

    public void displayDetails() {
        System.out.println(specificationByType);
    }
}
