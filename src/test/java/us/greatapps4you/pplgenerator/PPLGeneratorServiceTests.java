package us.greatapps4you.pplgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import us.greatapps4you.pplgenerator.domain.Person;
import us.greatapps4you.pplgenerator.service.PPLGeneratorServiceImpl;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@EnableAutoConfiguration
@ContextConfiguration(classes = {PPLGeneratorServiceImpl .class})
class PPLGeneratorServiceTests {

	@Autowired
	private PPLGeneratorServiceImpl service;
	private List<Person> generatedPeople;

	@Test
	void testNotNUllGeneratedPeople() {
		generatedPeople = service.generate(100);
		Assertions.assertNotNull(generatedPeople);
		Assertions.assertEquals(100, generatedPeople.size());
	}
}
