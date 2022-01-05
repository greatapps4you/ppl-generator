package us.greatapps4you.pplgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import us.greatapps4you.pplgenerator.domain.Person;
import us.greatapps4you.pplgenerator.service.PPLGeneratorServiceImpl;

import java.util.List;

@Disabled("Disabled for Java 11 adaptations")
@SpringBootTest(classes = Main.class)
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
