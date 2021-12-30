package us.greatapps4you.pplgenerator;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import us.greatapps4you.pplgenerator.domain.Person;
import us.greatapps4you.pplgenerator.service.PPLGeneratorService;

@SpringBootTest
class PPLGeneratorServiceTests {

	@Autowired
	private PPLGeneratorService service;
	private List<Person> generatedPeople;

	@Test
	void contextLoads() {
	}

	@Test
	void testNotNUllGeneratedPeople() {
		generatedPeople = service.generate(100);
		Assertions.assertNotNull(generatedPeople);
		Assertions.assertEquals(100, generatedPeople.size());
	}
}
