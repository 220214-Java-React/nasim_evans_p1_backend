package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Model.Reimbursement;
import com.revature.Service.FinancialManagerServices;
import com.revature.Tools.Log;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqString = req.getReader().lines().collect(Collectors.joining());
        String json = mapper.writeValueAsString(managerServices.getManagerHistory(Integer.parseInt(reqString.split(",")[0].split("\"")[3])));

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getOutputStream().println(json);
    }
    
}
