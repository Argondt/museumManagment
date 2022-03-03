package pl.fundacjamhw.museummanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MuseumManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuseumManagmentApplication.class, args);
    }

}
