package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Model.User;
import com.revature.Service.AdminServices;
import com.revature.Tools.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet("/admin")
public class AdminHomeController extends HttpServlet {

    private final AdminServices adminServices = new AdminServices();
    private final ObjectMapper mapper = new ObjectMapper();


    //Get new user registration list
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> userList = adminServices.getAllNewUsers();

        String json = mapper.writeValueAsString(userList);
        System.out.println(json);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getOutputStream().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqString = req.getReader().lines().collect(Collectors.joining());

        String intString = reqString.split(":")[1].substring(1).split("\"")[0];

        ArrayList<User> userList = adminServices.getAllAdminsUsers(Integer.parseInt(intString));

        String json = mapper.writeValueAsString(userList);
        System.out.println(json);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getOutputStream().println(json);
    }


}
