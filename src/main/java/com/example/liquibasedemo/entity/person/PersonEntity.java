package com.example.liquibasedemo.entity.person;

import com.example.liquibasedemo.entity.AbstractEntity;
import com.example.liquibasedemo.entity.license.LicenseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "employees", schema = "public")
public class PersonEntity extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "height")
    @Size(min = 1, max = 4)
    private String height;

    @Column(name = "income")
    private String income;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personEntity")
    private Collection<LicenseEntity> licenseEntities;

    public Collection<LicenseEntity> getLicenseEntities() {
        return licenseEntities;
    }

    public void setLicenseEntities(Collection<LicenseEntity> licenseEntities) {
        this.licenseEntities = licenseEntities;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public PersonEntity() {
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

    public static class PersonEntityBuilder {
        private String name;
        private String height;
        private String income;
        private Collection<LicenseEntity> licenseEntities;

        private PersonEntityBuilder() {

        }

        public static PersonEntityBuilder aPersonEntity() {
            return new PersonEntityBuilder();
        }

        public PersonEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonEntityBuilder withHeight(String height) {
            this.height = height;
            return this;
        }

        public PersonEntityBuilder withIncome(String income) {
            this.income = income;
            return this;
        }

        public PersonEntityBuilder withLicenseEntities(Collection<LicenseEntity> licenseEntities) {
            this.licenseEntities = licenseEntities;
            return this;
        }

        public PersonEntity build() {
            PersonEntity person = new PersonEntity();
            person.setName(this.name);
            person.setHeight(this.height);
            person.setIncome(this.income);
            person.setLicenseEntities(this.licenseEntities);
            return person;
        }
    }
}
