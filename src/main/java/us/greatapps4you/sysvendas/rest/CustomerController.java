package us.greatapps4you.sysvendas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.greatapps4you.sysvendas.domain.Customer;
import us.greatapps4you.sysvendas.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/list")
    public List<Customer> list() {
        List<Customer> allCustomers = new ArrayList<>();
        repository.findAll()
                .iterator()
                .forEachRemaining(allCustomers::add);
        return allCustomers;
    }

    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {
        System.out.println(customer);

        if(customer != null) {
            if(customer.getUuid() == null) {
                customer.setUuid(UUID.randomUUID());
            }
            repository.save(customer);
        }
    }

}
