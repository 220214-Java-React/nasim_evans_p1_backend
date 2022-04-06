package com.revature.Model.Enums;

public enum ReimbursementStatus {

    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DENIED("DENIED");

    public final String value;

    ReimbursementStatus(String value) {
        this.value = value;
    }
}
