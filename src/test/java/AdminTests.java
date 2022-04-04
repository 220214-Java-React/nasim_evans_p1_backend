import com.revature.Service.AdminServices;
import org.junit.jupiter.api.Test;

public class AdminTests {



    @Test
    public void getAllNewTest() {
        AdminServices as = new AdminServices();
        as.getAllNewUsers();
    }

    @Test
    public void getAllAdminTest() {
        AdminServices as = new AdminServices();
        as.getAllAdminsUsers(1);
    }
}
