package com.example.liquibasedemo.repository;

import com.example.liquibasedemo.entity.person.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<PersonEntity, UUID> {

    @Query("select p.name from PersonEntity p where p.name = :personName")
    String findByName(String personName);
}
