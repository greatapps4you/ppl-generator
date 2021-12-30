package us.greatapps4you.pplgenerator.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import us.greatapps4you.pplgenerator.domain.Person;

@Service
public class PPLGeneratorServiceImpl implements PPLGeneratorService {

	private List<Person> generatedPeople;
	private List<String> surnames;
	private List<String> firstNames;
	private List<String> emailProviders;

	public PPLGeneratorServiceImpl() throws NullPointerException, IOException {
		surnames = loadData("surnames.csv");
		firstNames = loadData("first_names.csv");
		emailProviders = loadData("email_providers.csv");

	}

	@Override
	public List<Person> generate(int amount) {
		generatePeople(amount);
		return generatedPeople;
	}

	private void generatePeople(int limit) {
		generatedPeople = new ArrayList<>();
		for (int i = 0; i < limit; i++) {
			String name = getRandom(firstNames);
			String surname = getRandom(surnames);
			String emailProvider = getRandom(emailProviders);
			generatedPeople.add(Person.builder().uuid(UUID.randomUUID()).age(generateRandomAge())
					.name(name + " " + surname).email((name + surname + "@" + emailProvider).toLowerCase()).build());
		}
	}

	private Integer generateRandomAge() {
		Random r = new Random();
		int low = 18;
		int high = 75;
		return r.nextInt(high - low) + low;
	}

	private String getRandom(List<String> list) {
		Random r = new Random();
		int low = 0;
		int high = list.size() - 1;
		int index = r.nextInt(high - low) + low;
		return list.get(index);
	}

	private List<String> loadData(String csvFileName) throws IOException, NullPointerException {
		List<String> data = new ArrayList<>();
		Resource resource = new ClassPathResource(csvFileName);		
		if (resource != null) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
				String line;
				while ((line = br.readLine()) != null) {
					data.add(line);
				}
			}
		}
		return data;
	}

}
