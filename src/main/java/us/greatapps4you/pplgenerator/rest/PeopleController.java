package us.greatapps4you.pplgenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import us.greatapps4you.pplgenerator.domain.Person;
import us.greatapps4you.pplgenerator.service.PPLGeneratorService;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PPLGeneratorService generator;

    @GetMapping("/generate/json/{amount}")
    @ResponseBody
    public List<Person> list(@PathVariable Integer amount) {  
        return generator.generate(amount);
    }

}
