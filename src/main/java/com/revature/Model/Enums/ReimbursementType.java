package com.revature.Model.Enums;

public enum ReimbursementType {

    LODGING("lodging"),
    TRAVEL("travel"),
    FOOD("food"),
    OTHER("other");

    public final String value;

    ReimbursementType(String value) {
        this.value = value;
    }


}
