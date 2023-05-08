package com.example.savvy.Repository;

import com.example.savvy.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User, Long> {
}
