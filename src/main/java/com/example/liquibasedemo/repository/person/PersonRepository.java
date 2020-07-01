package com.example.liquibasedemo.repository.person;

import com.example.liquibasedemo.entity.person.PersonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<PersonEntity, UUID> {

    @Query("select p.name from PersonEntity p where p.name = :personName")
    String findByName(String personName);

    @Transactional
    @Modifying
    @Query("update PersonEntity set updatedAt = 'now()' where id =:employeeId")
    void updatePerson(UUID employeeId);

    @Transactional
    @Modifying
    @Query("update PersonEntity set isActive = false where id =:employeeId")
    void deactivateEmployee(UUID employeeId);

    @Transactional
    @Modifying
    @Query("update PersonEntity set isActive = true where id =:employeeId")
    void activateEmployee(UUID employeeId);

    @Query("from PersonEntity p where p.isActive = true")
    List<PersonEntity> getActiveEmployees();
}
