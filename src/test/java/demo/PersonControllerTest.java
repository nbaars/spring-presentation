package demo;

import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;

@SpringApplicationConfiguration(classes = PresentationApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest("server.port:0")
public class PersonControllerTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void sayHello() {
        when().get("/persons").then().statusCode(HttpStatus.SC_OK).body("firstName", Matchers.hasItems("Jolyn", "Sylvester"));
    }

}