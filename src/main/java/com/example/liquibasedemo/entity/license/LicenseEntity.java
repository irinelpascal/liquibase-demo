package com.example.liquibasedemo.entity.license;

import com.example.liquibasedemo.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "licenses", schema = "public")
public class LicenseEntity extends AbstractEntity {

//    @ManyToOne
//    private PersonEntity personEntity;
//
//    public PersonEntity getPersonEntity() {
//        return personEntity;
//    }
//
//    public void setPersonEntity(PersonEntity personEntity) {
//        this.personEntity = personEntity;
//    }
}
