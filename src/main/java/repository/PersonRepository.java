package repository;

import entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    @Query("SELECT p.name from Person p where p.name like %:personName%")
    String findByName(String name);

}
