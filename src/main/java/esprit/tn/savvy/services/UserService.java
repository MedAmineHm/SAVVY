package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.User;
import esprit.tn.savvy.repositories.RepUser;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService implements IUserService {
    RepUser ru;

    @Override
    public User findUserByEmail(String email) {
       return ru.findUserByEmail(email);

    }

    @Override
        public User findUserById(Integer idUser) {
            return ru.findById(idUser).orElse(null);
        }
    }

