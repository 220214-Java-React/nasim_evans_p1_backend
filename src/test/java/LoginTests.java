import Model.Enums.Role;
import Model.User;
import Repository.UserRepository;
import Service.UserServices;
import Tools.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginTests {
    public static ObjectMapper mapper = new ObjectMapper();
//User Repository Tests
    @Test
    public void testThatUserRepositoryReturnsAdmin1User() {
        User user = new User("admin1", "password");
        UserRepository.login(user);
        Assertions.assertEquals(1, user.getUserId());
    }
    @Test
    public void testThatGetAllUsersWorks() {
        ArrayList<User> users = UserRepository.getAll();
        Assertions.assertEquals(4, users.size());
    }

//UserServices Tests
//    @Test
//    public void testThatUserServiceLoginWorks() {
//        Log.setupLogger();
//        try {
//            UserServices us = new UserServices();
//            User user = new User("admin1", "password");
//            us.login(user);
//            System.out.println(mapper.writeValueAsString(user));
//            Assertions.assertEquals(true, user.getUserId() == 1);
//        } catch(NoSuchAlgorithmException e) {
//            Log.logMessage("warn", e.getMessage());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testThatUserServiceCreateUserWorks() {
        try {
            UserServices userService = new UserServices();

            Assertions.assertEquals(true, userService.createUser("admin5", "admin5@adminSite.com", "brett12345", "adman", "strongtooth", Role.FINANCIALMANAGER));
        } catch (NoSuchAlgorithmException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }
    }


}
