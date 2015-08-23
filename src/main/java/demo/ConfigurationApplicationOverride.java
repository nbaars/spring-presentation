package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConfigurationApplicationOverride implements CommandLineRunner {

    static {
        System.setProperty("MAIL_USERNAME", "override");
    }

    private static Logger logger = LoggerFactory.getLogger(ConfigurationApplicationOverride.class);

    @Value("${mail.username}")
    private String username;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplicationOverride.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug(username);
    }
}


