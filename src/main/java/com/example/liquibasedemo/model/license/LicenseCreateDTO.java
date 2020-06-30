package com.example.liquibasedemo.model.license;

import java.io.Serializable;
import java.util.UUID;

public class LicenseCreateDTO implements Serializable {

    private String licenseName;
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
