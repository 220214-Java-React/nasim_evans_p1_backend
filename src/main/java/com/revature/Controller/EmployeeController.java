package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Model.Reimbursement;
import com.revature.Service.EmployeeServices;
import com.revature.Tools.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/services")
public class EmployeeController extends HttpServlet {

    private final EmployeeServices employeeServices = new EmployeeServices();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String reqString = req.getReader().lines().collect(Collectors.joining());
            Reimbursement reimb = mapper.readValue(reqString, Reimbursement.class);
            System.out.println(reimb.toString());

            employeeServices.createReimbursementRequest(reimb);

        } catch (Exception e) {
            Log.setupLogger();
            Log.logMessage("warn",e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int userId = Integer.parseInt(req.getParameter("userId"));
            System.out.println(userId);

            ArrayList<Reimbursement> reimbursementsList = employeeServices.getAllUsersRequests(userId);

            String json = mapper.writeValueAsString(reimbursementsList);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getOutputStream().println(json);

        } catch (Exception e) {
            Log.setupLogger();
            Log.logMessage("warn",e.getMessage());
        }
    }
}
