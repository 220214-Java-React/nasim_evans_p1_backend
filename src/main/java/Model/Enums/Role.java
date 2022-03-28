package Model.Enums;

public enum Role {
    ADMIN("admin"),
    FINACIALMANAGER("finacialmanager"),
    EMPLOYEE("employee");

    public final String value;

    Role(String value) {
        this.value = value;
    }
}
