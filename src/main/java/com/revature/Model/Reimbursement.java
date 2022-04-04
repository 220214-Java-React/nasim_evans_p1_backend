package com.revature.Model;

import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Model.Enums.ReimbursementType;

import java.awt.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Reimbursement {
    private SimpleDateFormat dateControl = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");

    private int reimbursementId;
    private double amount;
    private String timeSubmitted;
    private String timeResolved;
    private String description;
    private byte[] receipt;
    private int userId;
    private int managerId;
    private ReimbursementStatus status;
    private ReimbursementType type;


    public Reimbursement() {}

    //Get Reimbursement Full
    public Reimbursement(int reimbursementId, double amount, Date timeSubmitted, Date timeResolved, String description, byte[] receipt, int userId, int managerId, ReimbursementStatus status, ReimbursementType type) {
        this.reimbursementId = reimbursementId;
        this.amount = amount;
        this.timeSubmitted = dateControl.format(timeSubmitted);
        this.timeResolved = dateControl.format(timeResolved);
        this.description = description;
        this.receipt = receipt;
        this.userId = userId;
        this.managerId = managerId;
        this.status = status;
        this.type = type;
    }
    public Reimbursement(int reimbursementId, double amount, String timeSubmitted, String timeResolved, String description, byte[] receipt, int userId, int managerId, ReimbursementStatus status, ReimbursementType type) {
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

    public String getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(String timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public String getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(String timeResolved) {
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
