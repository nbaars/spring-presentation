package demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    public List<Person> listPersons() {
        Person p1 = Person.builder().firstName("Jolyn").lastName("Lichtenberger").build();
        Person p2 = Person.builder().firstName("Sylvester").lastName("Burrows").build();
        return Arrays.asList(p1, p2);
    }
}
