package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.FinancialManagerServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager")
public class ManagerController extends HttpServlet {
    private FinancialManagerServices managerServices = new FinancialManagerServices();
    private ObjectMapper mapper = new ObjectMapper();

    // get all active requests
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = mapper.writeValueAsString(managerServices.getAllPending());
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getOutputStream().println(json);
    }

    
}
