package esprit.tn.savvy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SavvyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SavvyApplication.class, args);
    }

}
