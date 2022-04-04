package com.revature.Model;

import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Model.Enums.ReimbursementType;

import java.util.Arrays;
import java.util.Calendar;

public class Reimbursement {

    private int reimbursementId;
    private double amount;
    private Calendar timeSubmitted;
    private Calendar timeResolved;
    private String description;
    private byte[] receipt;
    private int userId;
    private int managerId;
    private ReimbursementStatus status;
    private ReimbursementType type;

    //basic ReimbursementCreation
    public Reimbursement(double amount, Calendar timeSubmitted, String description, int userId, ReimbursementStatus status, ReimbursementType type) {
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.description = description;
        this.userId = userId;
        this.status = status;
        this.type = type;
    }

    //advanced Reimbursement creation
    public Reimbursement(double amount, Calendar timeSubmitted, String description, byte[] receipt, int userId, ReimbursementStatus status, ReimbursementType type) {
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.description = description;
        this.receipt = receipt;
        this.userId = userId;
        this.status = status;
        this.type = type;
    }

    //resolving constructor
    public Reimbursement(Calendar timeResolved, int managerId, ReimbursementStatus status) {
        this.timeResolved = timeResolved;
        this.managerId = managerId;
        this.status = status;
    }

    //Get Reimbursement Full
    public Reimbursement(int reimbursementId, double amount, Calendar timeSubmitted, Calendar timeResolved, String description, byte[] receipt, int userId, int managerId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbursementId = reimbursementId;
        this.amount = amount;
        this.timeSubmitted = timeSubmitted;
        this.timeResolved = timeResolved;
        this.description = description;
        this.receipt = receipt;
        this.userId = userId;
        this.managerId = managerId;
        this.status = status;
        this.type = type;
    }

    //getters and setters


    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Calendar getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(Calendar timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public Calendar getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(Calendar timeResolved) {
        this.timeResolved = timeResolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }


    //methods
    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", amount=" + amount +
                ", timeSubmitted=" + timeSubmitted +
                ", timeResolved=" + timeResolved +
                ", description='" + description + '\'' +
                ", receipt=" + Arrays.toString(receipt) +
                ", userId=" + userId +
                ", managerId=" + managerId +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
