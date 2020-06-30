package com.example.liquibasedemo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "createdOn")
    private Timestamp createdOn;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;
}
