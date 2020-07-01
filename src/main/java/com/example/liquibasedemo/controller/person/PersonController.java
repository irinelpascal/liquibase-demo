package com.example.liquibasedemo.controller.person;

import com.example.liquibasedemo.controller.ResponseMessage;
import com.example.liquibasedemo.entity.person.PersonEntity;
import com.example.liquibasedemo.model.person.PersonCreateDTO;
import com.example.liquibasedemo.repository.person.PersonRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName());
    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ApiOperation(value = "create a person", response = String.class)
    @PostMapping(value = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody PersonCreateDTO personCreateDTO) {

        PersonEntity personEntity = PersonEntity.PersonEntityBuilder.aPersonEntity()
                .withHeight(personCreateDTO.getHeight())
                .withName(personCreateDTO.getName())
                .withIncome(personCreateDTO.getIncome())
                .build();
        personEntity.setCreatedOn(new Timestamp(System.currentTimeMillis()));

        PersonEntity createdPerson = personRepository.save(personEntity);
        if (createdPerson != null) {
            LOGGER.info("Created person with id: " + createdPerson.getId());
        }
        return personRepository.findByName(personCreateDTO.getName()) + " saved";
    }

    @ApiOperation(value = "get all persons", response = String.class)
    @GetMapping(value = "/getAllPersons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonEntity> getAllPersons() {
        return (List<PersonEntity>) personRepository.findAll();
    }

    @ApiOperation(value = "delete a certain employee from the database", response = ResponseMessage.class)
    @DeleteMapping(value = "/removeEmployee/{employeeId}")
    public void removeEmployee(@PathVariable UUID employeeId) {
        personRepository.deleteById(employeeId);
        LOGGER.info("Employee with id: " + employeeId + " has been deleted");
    }

}
