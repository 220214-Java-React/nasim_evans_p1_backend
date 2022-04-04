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

@WebServlet("/employeeHistory")
public class EmployeeHistoryController extends HttpServlet {
    private EmployeeServices employeeServices = new EmployeeServices();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int userId = Integer.parseInt(req.getParameter("userId"));
            System.out.println(userId);

            ArrayList<Reimbursement> reimbursementsList = employeeServices.getAllUsersHistory(userId);

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
