package com.revature.Service;

import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Model.Reimbursement;
import com.revature.Repository.ReimbursementRepository;

import java.util.ArrayList;

public class FinancialManagerServices {

    ReimbursementRepository repository = new ReimbursementRepository();

    public ArrayList<Reimbursement> getAllPending() {
        return repository.getAllPending();
    }

    public ArrayList<Reimbursement> getManagerHistory(int managerId) {
        return repository.getAllHistoryByManagerId(managerId);
    }

    public void resolveReimbursement(int reimbursementId, String time, int managerId, ReimbursementStatus status) {
        repository.updateReimbursement(reimbursementId, time, managerId, status);
    }

}
