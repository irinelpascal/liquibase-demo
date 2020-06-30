package entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "persons", schema = "public")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "personName")
    private String name;

    @Column(name = "personHeight")
    private String height;

    public Person() {
    }

    public Person(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
