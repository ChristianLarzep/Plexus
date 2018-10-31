package com.lexus.demo.services;

import com.lexus.demo.entities.User;
import com.lexus.demo.repositories.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    @Autowired
    IRepositoryUser iRepositoryUser;

    public boolean registerUser(User user){
        if(iRepositoryUser.save(user) != null){
            return true;
        }

        return false;
    }

    public User findUserByEmailAndPassword(String email, String password){
        User oneUser = iRepositoryUser.findByEmailAndPassword(email, password);

        if(oneUser != null){
            return oneUser;
        }

        return null;
    }
}
