package us.greatapps4you.sysvendas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest {

    private List<Customer> testCustomers;
    private List<String> surnames;
    private List<String> firstNames;
    private List<String> emailProviders;

    @BeforeAll
    void setup() {
        try {
            surnames = loadData("surnames.csv");
            firstNames = loadData("first_names.csv");
            emailProviders = loadData("email_providers.csv");
            initTestCustomers(100);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testCustomers() {
        Assertions.assertNotNull(testCustomers);
        Assertions.assertTrue(testCustomers.size() > 0);
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

    private void initTestCustomers(int limit) {
        testCustomers = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            String name = getRandom(firstNames);
            String surname = getRandom(surnames);
            String emailProvider = getRandom(emailProviders);
            testCustomers.add(Customer.builder()
                    .uuid(UUID.randomUUID())
                    .age(generateRandomAge())
                    .name(name + " " + surname)
                    .email((name + surname + "@" + emailProvider).toLowerCase())
                    .build());
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

    private List<String> loadData(String csvFileName)
            throws IOException, NullPointerException {
        List<String> records = new ArrayList<>();

        final ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(csvFileName);
        if(resource != null) {
            final File csv = new File(resource.getFile());
            try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
                String line;
                while ((line = br.readLine()) != null) {
                    records.add(line);
                }
            }
        }
        return records;
    }
}