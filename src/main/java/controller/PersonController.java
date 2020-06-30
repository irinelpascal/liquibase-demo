package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repository.PersonRepository;

@RestController
public class PersonController {

    /*
     * @PreAuthorizeMethod(value = ENABLE_ORGANIZATIONS)
     * @ApiOperation(value = "Enable an organization by organizationId",
     * response = OrganizationSearchDTO.class)
     * @PostMapping(value = {"/be/organization/enable/{organizationId}", "/api/organization/enable/{organizationId}"},
     * produces = MediaType.APPLICATION_JSON_VALUE)
     */

//    @PostMapping("/person")
//    public String createPerson(@RequestParam String name) {
//        personRepository.save(new Person(name, "1.81"));
//        return personRepository.findByName(name) + " saved";
//    }

    @GetMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String testMethod() {
        return "test";
    }
}
