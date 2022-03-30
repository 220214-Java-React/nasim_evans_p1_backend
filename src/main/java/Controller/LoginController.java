package Controller;

import Tools.Log;
import Model.User;
import Service.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


/**
 * The UserController servlet will expose an endpoint to manipulate the User resource
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {


    //private static final Log logger = LogManager.getLogger(UserController.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static UserServices userService;
    

    static {
        try {
            userService = new UserServices();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: add functionality to get single users by either their username, or their id
        // get the username and password from the request
        // give those values to userService login method
        // give back json object to the response

        Log.setupLogger();
        try {
            System.out.println(req.getQueryString().split("&")[0]);

            String username = req.getParameter("username");
//            Log.logMessage("info", username);
            String password = req.getParameter("password");
//            Log.logMessage("info", password);
            User user = new User();
            user.setUserName(username);
            user.setUserPassword(password);
            userService.login(user);

            String JSON = mapper.writeValueAsString(user);

            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);

        }catch (Exception e) {
            Log.logMessage("warn", e.getMessage() );
        }

    }



}