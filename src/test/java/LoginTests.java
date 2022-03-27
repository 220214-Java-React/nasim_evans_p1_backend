import Model.User;
import Repository.UserRepository;
import Service.UserServices;
import Tools.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class LoginTests {

    @Test
    public void testThatUserRepositoryReturnsAdmin1User() {
        User user = UserRepository.login("admin1", "password");
        Assertions.assertEquals("admin1", user.getUserName());
    }

    @Test
    public void testThatUserServiceWorks() {
        try {
            UserServices us = new UserServices();
            Assertions.assertEquals(true, us.login("admin1", "password"));
        } catch(NoSuchAlgorithmException e) {
            Log.logMessage("warn", e.getMessage());
        }
    }

}
