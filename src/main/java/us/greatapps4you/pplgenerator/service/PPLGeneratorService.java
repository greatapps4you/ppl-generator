package us.greatapps4you.pplgenerator.service;

import java.util.List;

import us.greatapps4you.pplgenerator.domain.Person;

public interface PPLGeneratorService {
	List<Person> generate(int amount);
}
