package com.example.liquibasedemo.model.license;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.UUID;

public class LicenseCreateDTO implements Serializable {

    @NotBlank(message = "License name cannot be empty")
    private String licenseName;
    @NotBlank(message = "You have to add an id of a person")
    private UUID personEntityId;

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public UUID getPersonEntityId() {
        return personEntityId;
    }

    public void setPersonEntityId(UUID personEntityId) {
        this.personEntityId = personEntityId;
    }

}
