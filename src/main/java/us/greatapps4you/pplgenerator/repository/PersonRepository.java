package us.greatapps4you.pplgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import us.greatapps4you.pplgenerator.domain.Person;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
