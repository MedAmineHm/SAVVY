package esprit.tn.savvy.services;

import esprit.tn.savvy.entities.User;

public interface IUserService {


    User findUserByEmail(String email);

    User findUserById(Integer idUser);
}
