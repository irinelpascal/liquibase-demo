package com.example.liquibasedemo.controller.license;

import com.example.liquibasedemo.controller.ResponseMessage;
import com.example.liquibasedemo.entity.license.LicenseEntity;
import com.example.liquibasedemo.entity.person.PersonEntity;
import com.example.liquibasedemo.exception.person.PersonNotActiveException;
import com.example.liquibasedemo.model.license.LicenseCreateDTO;
import com.example.liquibasedemo.model.license.LicenseSearchDTO;
import com.example.liquibasedemo.repository.license.LicenseRepository;
import com.example.liquibasedemo.repository.person.PersonRepository;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class LicenseController {

    private static final Logger LOGGER = Logger.getLogger(LicenseController.class.getName());
    private LicenseRepository licenseRepository;
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LicenseController(LicenseRepository licenseRepository, PersonRepository personRepository, ModelMapper modelMapper) {
        this.licenseRepository = licenseRepository;
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "create a license", response = LicenseSearchDTO.class)
    @PostMapping(value = "/createLicense", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage createLicense(@RequestBody @Valid LicenseCreateDTO licenseCreateDTO) {

        Optional<PersonEntity> personById = personRepository.findById(UUID.fromString(licenseCreateDTO.getPersonEntityId()));
        if (personById.isPresent()) {
            PersonEntity foundPersonEntity = personById.get();
            LOGGER.info("Found employee with id: " + foundPersonEntity.getId());
            if (foundPersonEntity.isActive()) {
                LicenseEntity licenseEntity = LicenseEntity.LicenseEntityBuilder.aLicenseEntityBuilder()
                        .withPersonEntity(foundPersonEntity)
                        .withLicenseName(licenseCreateDTO.getLicenseName())
                        .build();
                licenseEntity.setCreatedOn(new Timestamp(System.currentTimeMillis()));
                foundPersonEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                personRepository.updatePerson(foundPersonEntity.getId()); //updated the updatedAt column
                LicenseEntity createdLicenseEntity = licenseRepository.save(licenseEntity);
                if (createdLicenseEntity != null) {
                    LOGGER.info("License with id: " + createdLicenseEntity.getId() + " has been created");
                    return new ResponseMessage(modelMapper.map(createdLicenseEntity, LicenseSearchDTO.class));
                }
            }
            throw new PersonNotActiveException("Person is not active!", "Please check status of person with id: " + personById.get().getId());
        }
        LOGGER.info("Something went wrong during the creation of the license");
        return new ResponseMessage(null);
    }


}
