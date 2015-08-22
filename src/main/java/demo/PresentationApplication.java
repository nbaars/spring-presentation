package demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PresentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);
    }
}

@RestController
class PersonController {

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    public List<Person> listPersons() {
        Person p1 = Person.builder().firstName("Jan Willem").lastName("Jonker").build();
        Person p2 = Person.builder().firstName("Walter").lastName("Bredero").build();
        return Arrays.asList(p1, p2);
    }
}

@Data
@Builder
class Person {

    private final String firstName;
    private final String lastName;
}
