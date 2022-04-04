package com.revature.Model.Enums;

public enum ReimbursementStatus {

    PENDING("pending"),
    APPROVED("approved"),
    DENIED("denied");

    public final String value;

    ReimbursementStatus(String value) {
        this.value = value;
    }
}
