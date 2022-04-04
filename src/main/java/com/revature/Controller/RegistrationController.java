package com.revature.Controller;

import com.revature.Model.User;
import com.revature.Service.UserServices;
import com.revature.Tools.Log;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/create")
public class RegistrationController extends HttpServlet {

    //private static final Log logger = LogManager.getLogger(UserController.class);

    private static UserServices userService = new UserServices();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log.setupLogger();

        String givenJson = req.getReader().lines().collect(Collectors.joining());

        User user = mapper.readValue(givenJson, User.class);

        userService.createUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getRole());
        user = userService.login(user);

        String JSON = "{ \"text\":";

        if (user.getUserId() != 0) {
            JSON += "\"User has been created. an admin will review your account\" }";
            System.out.println(JSON);
            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);
            resp.setStatus(200);
        }else {
            JSON += "\"User has not been created. try again please\" }";
            System.out.println(JSON);
            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);
            resp.setStatus(400);
        }

    }
}
