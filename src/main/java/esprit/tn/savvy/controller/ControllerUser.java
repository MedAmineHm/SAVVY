package esprit.tn.savvy.controller;

import esprit.tn.savvy.Services.IUserService;
import esprit.tn.savvy.Services.UserService;
import esprit.tn.savvy.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerUser  {
    IUserService iUserService ;

    @GetMapping("findall")
    public List<User> getAllUsers() {
        return iUserService.findAll();
    }
    @PostMapping("add")
    public User addUser(@RequestBody User user){
        return iUserService.addUser(user);    }
    @GetMapping("findById")
    public User getUsersById(Long Id) {
        return iUserService.findUserById(Id);
    }
@GetMapping("{UserId}")
public User retrieveUser(@PathVariable Long UserId) {
    User user = iUserService.retrieveUser(UserId);
    if (user != null) {
    }  return user;

}
    @DeleteMapping("{UserId}")
    public void removeUserById(@PathVariable Long UserId) {
        User user = iUserService.retrieveUser(UserId);
        if (user != null) {
            iUserService.removeUser(user);

        }
    }
}



