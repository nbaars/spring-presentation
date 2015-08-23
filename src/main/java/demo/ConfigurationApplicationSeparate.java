package demo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.validation.constraints.NotNull;
import java.net.InetAddress;

@SpringBootApplication
public class ConfigurationApplicationSeparate implements CommandLineRunner {

    @Autowired
    private MailConfiguration mailConfiguration;

    private static Logger logger = LoggerFactory.getLogger(ConfigurationApplicationSeparate.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplicationSeparate.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("From is set to: {}", mailConfiguration.getFrom());
        logger.debug("Template is read from {}", mailConfiguration.getTemplateSignature().getDescription());
    }
}

@ConfigurationProperties(prefix = "mail")
@Data
@Configuration
class MailConfiguration {

    @Email
    private String from;
    @NotNull
    private String username;
    private InetAddress host;
    private Resource templateSignature;
}

class MailSender {

    @Autowired
    private MailConfiguration mailConfiguration;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(mailConfiguration.getUsername());

        return mailSender;
    }
}




