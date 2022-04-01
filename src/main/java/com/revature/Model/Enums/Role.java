package com.revature.Model.Enums;

public enum Role {
    ADMIN("admin"),
    FINANCIALMANAGER("financialmanager"),
    EMPLOYEE("employee"),
    EMPTY("empty");

    public final String value;

    Role(String value) {
        this.value = value;
    }
}
