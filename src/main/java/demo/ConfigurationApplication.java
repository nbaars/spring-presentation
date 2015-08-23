package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ConfigurationApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(ConfigurationApplication.class);

    @Value("${mail.username}")
    private String username;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug(username);
    }
}


