package com.revature.Controller;

import com.revature.Tools.Log;
import com.revature.Model.User;
import com.revature.Service.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginController extends HttpServlet {


    //private static final Log logger = LogManager.getLogger(UserController.class);

    private static UserServices userService = new UserServices();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log.setupLogger();
        try {

            User user = mapper.readValue(req.getReader().lines().collect(Collectors.joining()), User.class);
            System.out.println(user);
            user = userService.login(user);
            String respJson = mapper.writeValueAsString(user);
            //System.out.println(respJson);

            if (user.getUserId() != 0) {
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.getOutputStream().println(respJson);

            }else {
                resp.setStatus(400);
                resp.setContentType("application/text");
                resp.getOutputStream().println("We could not find that user");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}