package Service;

import Model.Enums.Role;
import Model.User;
import Repository.UserRepository;
import Tools.Log;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServices {

    private final BCrypt.Hasher hasher;
    private final ObjectMapper mapper = new ObjectMapper();


    public UserServices () throws NoSuchAlgorithmException {
        this.hasher = BCrypt.withDefaults();
    }

    public List<User> getAll() {
        return UserRepository.getAll();
    }


    public String login(String username, String password) throws IOException {
        // get a user from the user repository using username and secured password
        User user = new User(username, password);

        if (!user.getUserPassword().equals("password")) {
            user.setUserPassword(securePassword(user.getUserPassword()));
        }
        System.out.println(user);
        user = UserRepository.login(user);
        System.out.println(user);

        return mapper.writeValueAsString(user);
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
