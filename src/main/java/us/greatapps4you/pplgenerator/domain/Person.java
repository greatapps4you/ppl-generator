package us.greatapps4you.pplgenerator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private UUID uuid;
    private String name;
    private String email;
    private Integer age;

}
