package com.example.liquibasedemo.entity.person;

import com.example.liquibasedemo.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persons", schema = "public")
public class PersonEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    @Size(min = 1, max = 4)
    private String height;

//    @OneToMany(mappedBy = "personEntity")
//    private List<LicenseEntity> licenseEntities;

    public PersonEntity() {
    }

    public PersonEntity(String name, String height) {
        this.name = name;
        this.height = height;
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
