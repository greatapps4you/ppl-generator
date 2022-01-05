package us.greatapps4you.pplgenerator.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

    @Id
    private UUID uuid;
    private String name;
    private String email;
    private Integer age;

    public Person(UUID uuid, String name, String email, Integer age) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
