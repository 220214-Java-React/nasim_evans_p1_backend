import Model.Enums.Role;
import Model.User;
import Repository.UserRepository;
import Service.UserServices;
import Tools.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginTests {

//User Repository Tests
    @Test
    public void testThatUserRepositoryReturnsAdmin1User() {
        User user = UserRepository.login("admin1", "password");
        Assertions.assertEquals("admin1", user.getUserName());
    }
    @Test
    public void testThatGetAllUsersWorks() {
        ArrayList<User> users = UserRepository.getAll();
        Assertions.assertEquals(1, users.size());
    }

//UserServices Tests
    @Test
    public void testThatUserServiceLoginWorks() {
        Log.setupLogger();
        try {
            UserServices us = new UserServices();
            Assertions.assertEquals(true, us.login("admin1", "password"));
        } catch(NoSuchAlgorithmException e) {
            Log.logMessage("warn", e.getMessage());
        }
    }

    @Test
    public void testThatUserServiceCreateUserWorks() {
        try {
            UserServices userService = new UserServices();

            Assertions.assertEquals(true, userService.createUser("admin4", "admin4@adminSite.com", "brett12345", "adman", "strongtooth", Role.FINACIALMANAGER));
        } catch (NoSuchAlgorithmException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }
    }


}
