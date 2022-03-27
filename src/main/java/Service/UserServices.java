package Service;

import Model.User;
import Repository.UserRepository;
import Tools.Log;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServices {

    private final MessageDigest messageDigest;


    public UserServices () throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-512");
    }


    public boolean login(String username, String password) {
        // get a user from the user repository using username and secured password
        User user = UserRepository.login(username, securePassword(password));

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



    //securePassword: takes the password and encrypts it before
    //                either being created with a new user or logging in
    private String securePassword(String pass) {
        return new String(messageDigest.digest(pass.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }


}
