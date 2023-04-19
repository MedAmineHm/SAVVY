package esprit.tn.savvy.repositories;

import esprit.tn.savvy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepUser extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);


}
