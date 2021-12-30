package us.greatapps4you.pplgenerator.domain;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CSVdataTest {

	private List<String> surnames;
	private List<String> firstNames;
	private List<String> emailProviders;

	@BeforeAll
	void setup() {
		try {
			surnames = loadData("surnames.csv");
			firstNames = loadData("first_names.csv");
			emailProviders = loadData("email_providers.csv");
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void testSurnames() {
		Assertions.assertNotNull(surnames);
	}

	@Test
	void testFirstNames() {
		Assertions.assertNotNull(firstNames);
	}

	@Test
	void testEmailProviders() {
		Assertions.assertNotNull(emailProviders);
	}

	private List<String> loadData(String csvFileName) throws IOException, NullPointerException {
		List<String> data = new ArrayList<>();

		final ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(csvFileName);
		if (resource != null) {
			final File csv = new File(resource.getFile());
			try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
				String line;
				while ((line = br.readLine()) != null) {
					data.add(line);
				}
			}
		}
		return data;
	}
}