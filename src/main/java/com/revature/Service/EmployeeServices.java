package com.revature.Service;

import com.revature.Model.Reimbursement;
import com.revature.Repository.ReimbursementRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class EmployeeServices {
    ReimbursementRepository reimbursementRepository = new ReimbursementRepository();

    public void createReimbursementRequest(Reimbursement reimb) {
        reimbursementRepository.createReimbursement(reimb);
    }

    public ArrayList getAllUsersRequests(int userId) {
        ArrayList<Reimbursement> list = reimbursementRepository.getAllByUserId(userId);
        return list;
    }

    public ArrayList getAllUsersHistory(int userId) {
        ArrayList<Reimbursement> list = reimbursementRepository.getAllHistoryByUserId(userId);
        return list;
    }

    public void deleteRequestById(int reimbursementId) {
        reimbursementRepository.deleteRequestById(reimbursementId);
    }
}
