package Model.Enums;

public enum Role {
    ADMIN("admin"),
    FINANCIALMANAGER("financialmanager"),
    EMPLOYEE("employee");

    public final String value;

    Role(String value) {
        this.value = value;
    }
}
