package esprit.tn.savvy.Services;

import esprit.tn.savvy.Repository.UserRepository;
import esprit.tn.savvy.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService implements IUserService {
    UserRepository ur ;
    @Override
    public List<User> findAll() {
        return ur.findAll();
    }

    @Override
    public User addUser(User user) {
        return ur.save(user);
    }
    @Override
    public User findUserById(Long UserId){
        return ur.findById(UserId).orElse(null);
    }
    @Override
    public void removeUser(User user) {
        ur.delete(user);}

    @Override
    public User retrieveUser(Long UserId) {
        return ur.findById(UserId).orElse(null);
    }
}
