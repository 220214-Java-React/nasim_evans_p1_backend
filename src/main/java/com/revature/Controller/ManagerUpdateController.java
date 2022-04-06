package com.revature.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Service.FinancialManagerServices;
import com.revature.Tools.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/managerUpdate")
public class ManagerUpdateController extends HttpServlet {
    private FinancialManagerServices managerServices = new FinancialManagerServices();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqString = req.getReader().lines().collect(Collectors.joining());
        System.out.println(reqString);

        try {
            int reimbId = Integer.parseInt(reqString.split(",")[0].split("\"")[3]);
            String timeResolved = reqString.split(",")[1].split("\"")[3];
            int managerId = Integer.parseInt(reqString.split(",")[2].split("\"")[3]);
            ReimbursementStatus statusEnum = ReimbursementStatus.valueOf(reqString.split(",")[3].split("\"")[3]);
            System.out.println(reqString.split(",")[3].split("\"")[3]);
            managerServices.resolveReimbursement(reimbId,timeResolved, managerId, statusEnum);

        } catch (Exception e) {
            Log.setupLogger();
            Log.logMessage("warn", "prob" +e.getMessage());

        }


    }
}




