import Model.User;
import Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests {


    @Test
    public void testThatUserIsFoundWithCorrectCredentials() {
        UserRepository ur = new UserRepository();
        User user = ur.checkLogin("admin1", "password");
        Assertions.assertEquals("admin1", user.getUserName());
    }

    @Test
    public void testThatUserIsNotFoundBecauseOfIncorrectUserName() {
        UserRepository ur = new UserRepository();
        User user = ur.checkLogin("admin", "password");
        Assertions.assertEquals(null, user.getUserName());
    }

    @Test
    public void testThatUserIsNotFoundBecauseOfIncorrectPassword() {
        UserRepository ur = new UserRepository();
        User user = ur.checkLogin("admin1", "passord");
        Assertions.assertEquals(null, user.getUserName());
    }


    //@Test
    //public void testThatUserIsFoundWithCorrectCredentialsButIsDeniedAccessByAdmin() {}

}
