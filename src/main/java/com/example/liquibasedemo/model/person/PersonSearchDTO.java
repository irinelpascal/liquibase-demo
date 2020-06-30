package com.example.liquibasedemo.model.person;

import com.example.liquibasedemo.entity.license.LicenseEntity;

import java.util.Collection;

public class PersonSearchDTO {

    private String name;
    private String height;
    private String income;
    private Collection<LicenseEntity> licenseEntities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
