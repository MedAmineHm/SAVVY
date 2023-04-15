package esprit.tn.savvy.Payload;

import lombok.Data;
@Data
public class Login {

    private String usernameOrEmail;
    private String password;
}
