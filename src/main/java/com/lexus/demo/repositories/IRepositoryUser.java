package com.lexus.demo.repositories;

import com.lexus.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
}
