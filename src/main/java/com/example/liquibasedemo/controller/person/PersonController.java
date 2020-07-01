package com.example.liquibasedemo.controller.person;

import com.example.liquibasedemo.controller.ResponseMessage;
import com.example.liquibasedemo.entity.AbstractEntity;
import com.example.liquibasedemo.entity.license.LicenseEntity;
import com.example.liquibasedemo.entity.person.PersonEntity;
import com.example.liquibasedemo.model.person.PersonCreateDTO;
import com.example.liquibasedemo.model.person.PersonSearchDTO;
import com.example.liquibasedemo.repository.person.PersonRepository;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName());
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PersonController(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "create a person", response = String.class)
    @PostMapping(value = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody @Valid PersonCreateDTO personCreateDTO) {

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

    @ApiOperation(value = "delete a certain employee from the database; hard delete", response = ResponseMessage.class)
    @DeleteMapping(value = "/removeEmployee/{employeeId}")
    public ResponseMessage removeEmployee(@PathVariable UUID employeeId) {
        personRepository.deleteById(employeeId);
        LOGGER.info("Employee with id: " + employeeId + " has been deleted");
        return new ResponseMessage("Employee with id: " + employeeId + " has been removed from the database");
    }

    @ApiOperation(value = "deactivate /a activate an employee", response = ResponseMessage.class)
    @PutMapping(value = {"/deactivateEmployee/{employeeId}", "/activateEmployee/{employeeId}"})
    public ResponseMessage activateOrDeactivateEmployee(@PathVariable UUID employeeId, HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getRequestURI().contains("/activateEmployee/") && httpServletRequest.getMethod().equalsIgnoreCase("put")) {
            personRepository.activateEmployee(employeeId);
            LOGGER.info("Employee with id: " + employeeId + " has been activated");
            return new ResponseMessage("Employee with id: " + employeeId + " has been activated");
        } else if (httpServletRequest.getRequestURI().contains("/deactivateEmployee/") && httpServletRequest.getMethod().equalsIgnoreCase("put")) {
            personRepository.deactivateEmployee(employeeId);
            LOGGER.info("Employee with id: " + employeeId + " has been activated");
            return new ResponseMessage("Employee with id: " + employeeId + " has been deactivated");
        } else {
            throw new IllegalStateException("Not allowed to call this endpoint!");
        }
    }


    @ApiOperation(value = "Retrieve active employees", response = PersonSearchDTO.class)
    @GetMapping(value = "/getActiveEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getActiveEmployees() {
        List<PersonEntity> activeEmployees = personRepository.getActiveEmployees();
        List<PersonSearchDTO> result = new LinkedList<>();
        if (!CollectionUtils.isEmpty(activeEmployees)) {
            activeEmployees.forEach(activeEmployee -> {
                PersonSearchDTO personSearchDTO = modelMapper.map(activeEmployee, PersonSearchDTO.class);
                if (!CollectionUtils.isEmpty(activeEmployee.getLicenseEntities())) {
                    Set<UUID> licenseEntityIds = activeEmployee.getLicenseEntities()
                            .stream()
                            .map(LicenseEntity::getId)
                            .collect(Collectors.toSet());
                    personSearchDTO.setLicenseEntityIds(licenseEntityIds);
                }
                result.add(personSearchDTO);
            });
            return new ResponseMessage(result);
        }
        LOGGER.info("There are no active employees");
        return new ResponseMessage("No active employees");
    }
}
