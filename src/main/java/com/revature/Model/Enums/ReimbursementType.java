package com.revature.Model.Enums;

public enum ReimbursementType {

    LODGING("LODGING"),
    TRAVEL("TRAVEL"),
    FOOD("FOOD"),
    OTHER("OTHER");

    public final String value;

    ReimbursementType(String value) {
        this.value = value;
    }


}
