package com.example.liquibasedemo.model.license;

import java.sql.Timestamp;
import java.util.UUID;

public class LicenseSearchDTO {

    private UUID id;
    private Timestamp createdOn;
    private Timestamp updatedAt;
    private String licenseName;
    private UUID personEntityId;
    private UUID licenseKey;

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

    public UUID getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(UUID licenseKey) {
        this.licenseKey = licenseKey;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
