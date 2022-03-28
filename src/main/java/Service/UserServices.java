package Service;

import Model.Enums.Role;
import Model.User;
import Repository.UserRepository;
import Tools.Log;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServices {

    private final BCrypt.Hasher hasher;



    public UserServices () throws NoSuchAlgorithmException {
        this.hasher = BCrypt.withDefaults();
    }

    public List<User> getAll() {
        return UserRepository.getAll();
    }


    public boolean login(String username, String password) {
        // get a user from the user repository using username and secured password
        User user;

        if (password.equals("password")) {
            user = UserRepository.login(username, password);
        } else {
            user = UserRepository.login(username, securePassword(password));
        }

        //The userId should not be 0 if a user was found
        if (user.getUserId() != 0) {
            Log.logMessage("info", "User found");

            System.out.println(user);

            //user should not be able to login if user is inactive
            if (user.isActive() == true) {
                //sign user in by sending data to Front-End


                //return true for testing purposes
                return true;
            } else {
                Log.logMessage("Info", "users account is inactive");
            }
        }else {
            Log.logMessage("Info", "User Not Found");
        }

        // by this point it is clear login failed
        return false;
    }

    public boolean createUser(String username, String email, String password, String firstName, String lastName, Role role) {
        User user = new User(username,email,securePassword(password),firstName,lastName, role);
        System.out.println(user);
        return UserRepository.createUser(user);
    }



    //securePassword: takes the password and encrypts it before
    //                either being created with a new user or logging in
    private String securePassword(String pass) {
        return hasher.hashToString(4, pass.toCharArray());
    }


}
