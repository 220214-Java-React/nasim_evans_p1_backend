package com.revature.Model.Enums;

public enum Role {
    ADMIN("ADMIN"),
    FINANCIALMANAGER("FINANCIALMANAGER"),
    EMPLOYEE("EMPLOYEE"),
    EMPTY("EMPTY");

    public final String value;

    Role(String value) {
        this.value = value;
    }
}
