package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SimpleSmallRestController {

    @RequestMapping(value = "/hello")
    public String helloWorld() {
        return "Hello Spring Boot!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleSmallRestController.class, args);
    }


}
