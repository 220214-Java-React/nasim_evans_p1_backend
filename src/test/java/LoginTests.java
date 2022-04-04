import com.revature.Model.Enums.Role;
import com.revature.Model.User;
import com.revature.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LoginTests {
    public static ObjectMapper mapper = new ObjectMapper();
    UserRepository userRepository = new UserRepository();
//User Repository Tests
    @Test
    public void testThatUserRepositoryReturnsAdmin1User() {
        User user = new User("admin1", "password");
        user = userRepository.login(user);
        Assertions.assertEquals(1, user.getUserId());
    }

//UserServices Tests
    @Test
    public void testThatUserServiceLoginWorks() {
        UserServices us = new UserServices();
        User user = new User("evans", "brett");

        System.out.println();
        Assertions.assertEquals(18, us.login(user).getUserId());

    }
//
    @Test
    public void testThatUserServiceCreateUserWorks() {
        UserServices userService = new UserServices();
        Assertions.assertEquals(true, userService.createUser("evans", "buttercup@outlokk.com", "brett", "adman", "strongtooth", Role.EMPLOYEE));
    }


}
