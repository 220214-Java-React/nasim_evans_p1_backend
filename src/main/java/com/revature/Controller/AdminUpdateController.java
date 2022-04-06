package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/adminUpdate")
public class AdminUpdateController extends HttpServlet {

    private final AdminServices adminServices = new AdminServices();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

        String request = req.getReader().lines().collect(Collectors.joining());
        System.out.println(request);

        int activeState = Integer.parseInt(request.split(",")[0].split("=")[1].substring(1).split("\"")[0]);
        int userId = Integer.parseInt(request.split(",")[1].split("=")[1].substring(1).split("\"")[0]);
        int adminId = Integer.parseInt(request.split(",")[2].split("=")[1].substring(1).split("\"")[0]);

        System.out.println(activeState);
        System.out.println(userId);
        System.out.println(adminId);

        adminServices.updateActiveState(activeState, userId, adminId);

    }


}
