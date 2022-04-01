package com.revature.Service;

import com.revature.Model.Enums.Role;
import com.revature.Model.User;
import com.revature.Repository.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserServices {
    private final String SALT = "83c@u$e!AmBatM@n";
    private BCrypt.Hasher hasher = null;
    private UserRepository userRepository;


    public UserServices () {
        try {
            this.userRepository = new UserRepository();
            this.hasher = BCrypt.withDefaults();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }


    public User login(User user) {
        String newPass = securePassword(user.getPassword());
        System.out.println(newPass);
        user.setPassword(newPass);
        System.out.println(user);
        user = userRepository.login(user);

//        if (user.getUserId() == 0) {
//
//            user.nullify();
//
//        }

        return user;
    }

    public boolean createUser(String username, String email, String password, String firstName, String lastName, Role role) {
        User user = new User(username,email,securePassword(password),firstName,lastName, role);
        System.out.println(user);
        return userRepository.createUser(user);
    }



//    securePassword: takes the password and encrypts it before
//                    either being created with a new user or logging in
    private String securePassword(String pass) {
        return new String(hasher.hash(4, SALT.getBytes(StandardCharsets.UTF_8), pass.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }


}
