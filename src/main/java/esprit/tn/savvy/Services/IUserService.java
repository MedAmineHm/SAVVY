package esprit.tn.savvy.Services;

import esprit.tn.savvy.Repository.UserRepository;
import esprit.tn.savvy.entities.User;

import java.util.List;

public interface IUserService  {

    List<User> findAll();

    User addUser(User user);
    User findUserById (Long UserId) ;

    void removeUser(User user);
    User retrieveUser(Long UserId);


    User updateUser(User user);
}
