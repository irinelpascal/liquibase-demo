package com.example.liquibasedemo.model.license;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.UUID;

public class LicenseCreateDTO implements Serializable {

    @NotBlank(message = "License name cannot be empty")
    private String licenseName;

    @NotBlank(message = "You have to add an id of a person")
    private String personEntityId;

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public String getPersonEntityId() {
        return personEntityId;
    }

    public void setPersonEntityId(String personEntityId) {
        this.personEntityId = personEntityId;
    }
}
