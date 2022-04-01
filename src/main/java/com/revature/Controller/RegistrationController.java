package com.revature.Controller;

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
        System.out.println(givenJson);

        //createUser(String username, String email, String password, String firstName, String lastName, Role role)
    }
}
