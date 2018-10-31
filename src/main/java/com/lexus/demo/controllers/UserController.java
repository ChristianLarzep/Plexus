package com.lexus.demo.controllers;

import com.lexus.demo.services.UserDao;
import com.lexus.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("/user")
    @CrossOrigin(origins = "*")
    public boolean registerUser(@RequestBody User user){
        if(userDao.registerUser(user)){
            return true;
        }

        return false;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public User loginUser(@RequestBody User user){
        User temp = userDao.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if(temp != null){
            return temp;
        }

        return null;
    }

}

/*
{
	"username":"Irvin Colli",
    "email": "colli@live.com",
    "password": "something",
    "role": "ADVISER",
    "cell": 23345656,
    "tel": 24354675,
    "rfc":"URNF756FJ",
    "r_social":"CarlosInc"
}
*/