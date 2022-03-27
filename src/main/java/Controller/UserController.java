package Controller;

import Repository.UserRepository;
import Tools.Log;
import Tools.Log.*;
import Model.User;
import Service.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.stream.Collectors;


/**
 * The UserController servlet will expose an endpoint to manipulate the User resource
 */

public class UserController extends HttpServlet {


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: add functionality to get single users by either their username, or their id

        // get all users
        List<User> users = userService.getAll();
        String JSON = "";
        // still in java form, what do I need to do? Convert to JSON String (aka Marshalling)
        try{
            JSON = mapper.writeValueAsString(users);

            // after its in string form, I need to do a few things to get it back to the user, what are they?
            response.setContentType("application/json"); // inform the caller that we are sending JSON back
            response.setStatus(200); // inform the caller that the operation was a success
            response.getOutputStream().println(JSON); // write the data to the body of the response
        } catch(Exception e){
           // logger.warn(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Extract the request payload in JSON form from the BufferedReader on the request object
        String JSON = req.getReader().lines().collect(Collectors.joining());
        User user = null;

        // We unmarshall the JSON string into a Java instance of the User class
        try{
            user = mapper.readValue(JSON, User.class);

            // we have a new user object -> what do we do with it?
            // try and persist it to the database, however we should not go to our Repository directly.
            // We should instead pass this variable to the UserService so that it can handle sending to the DAO.
            //UserRepository.createUser();
        } catch(Exception e){
           // logger.warn(e);
        }


        // 200 - OK, 201 - Created is good if you're returning, 204 - No Content
        resp.setStatus(204);
    }
}