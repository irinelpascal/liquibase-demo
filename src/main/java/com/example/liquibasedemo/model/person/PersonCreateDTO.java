package com.example.liquibasedemo.model.person;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class PersonCreateDTO implements Serializable {

    @NotBlank(message = "Name of the person cannot pe empty")
    private String name;
    private String height;
    @NotBlank(message = "The income cannot pe empty")
    private String income;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

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
}
