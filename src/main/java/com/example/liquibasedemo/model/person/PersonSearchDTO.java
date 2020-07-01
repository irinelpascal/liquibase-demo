package com.example.liquibasedemo.model.person;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public class PersonSearchDTO {

    private Timestamp createdOn;
    private Timestamp updatedAt;
    private UUID id;
    private String name;
    private String height;
    private String income;
    private Set<UUID> licenseEntityIds;
    private boolean isActive;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<UUID> getLicenseEntityIds() {
        return licenseEntityIds;
    }

    public void setLicenseEntityIds(Set<UUID> licenseEntityIds) {
        this.licenseEntityIds = licenseEntityIds;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
