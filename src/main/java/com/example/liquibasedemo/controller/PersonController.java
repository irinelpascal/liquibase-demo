package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.entity.person.PersonEntity;
import com.example.liquibasedemo.model.PersonCreateDTO;
import com.example.liquibasedemo.repository.PersonRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ApiOperation(value = "create a person", response = String.class)
    @PostMapping(value = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody PersonCreateDTO personCreateDTO) {
        personRepository.save(new PersonEntity(personCreateDTO.getName(), "1.81"));
        return personRepository.findByName(personCreateDTO.getName()) + " saved";
    }

    @ApiOperation(value = "get all persons", response = String.class)
    @GetMapping(value = "/getAllPersons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonEntity> getAllPersons() {
        return (List<PersonEntity>) personRepository.findAll();
    }

}
