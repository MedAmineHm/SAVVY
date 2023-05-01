package esprit.tn.savvy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SavvyApplication {
    @GetMapping("/message")
    public String message(){
        return "Congrats! you app deployed successufully in azure";
    }

    public static void main(String[] args) {
        SpringApplication.run(SavvyApplication.class, args);
    }

}
