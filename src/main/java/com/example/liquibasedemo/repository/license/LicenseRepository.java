package com.example.liquibasedemo.repository.license;

import com.example.liquibasedemo.entity.license.LicenseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LicenseRepository extends CrudRepository<LicenseEntity, UUID> {

    @Query("select l.licenseName from LicenseEntity l where l.licenseName = :licenseName")
    String findById(String licenseName);
}
