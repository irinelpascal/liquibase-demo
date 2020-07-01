package com.example.liquibasedemo.entity.license;

import com.example.liquibasedemo.entity.AbstractEntity;
import com.example.liquibasedemo.entity.person.PersonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "licenses", schema = "public")
public class LicenseEntity extends AbstractEntity {

    @Column(name = "licenseName", nullable = false, unique = true)
    @Size(min = 3, max = 36)
    private String licenseName;

    @ManyToOne
    private PersonEntity personEntity;

    @Column(name = "licenseKey", unique = true, nullable = false)
    private UUID licenseKey;

    public UUID getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(UUID licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public static class LicenseEntityBuilder {

        private String licenseName;
        private PersonEntity personEntity;

        private LicenseEntityBuilder() {

        }

        public static LicenseEntityBuilder aLicenseEntityBuilder() {
            return new LicenseEntityBuilder();
        }

        public LicenseEntityBuilder withLicenseName(String licenseName) {
            this.licenseName = licenseName;
            return this;
        }

        public LicenseEntityBuilder withPersonEntity(PersonEntity personEntity) {
            this.personEntity = personEntity;
            return this;
        }

        public LicenseEntity build() {
            LicenseEntity licenseEntity = new LicenseEntity();
            licenseEntity.setPersonEntity(this.personEntity);
            licenseEntity.setLicenseKey(UUID.randomUUID());
            licenseEntity.setLicenseName(this.licenseName);
            return licenseEntity;
        }
    }
}
