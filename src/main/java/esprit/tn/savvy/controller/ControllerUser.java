package esprit.tn.savvy.controller;

import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.services.IUserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerUser {
    IUserService userService;

    @GetMapping("/{idUser}")
    public User findUserById(@PathVariable Integer idUser) {
        return userService.findUserById(idUser);
    }
}
