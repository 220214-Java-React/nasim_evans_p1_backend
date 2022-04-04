package com.revature.Model;
import com.revature.Model.Enums.Role;

public class User {
    private int userId = 0;
    private String username = "";
    private String password = "";
    private String email = "";
    private String firstName = "";
    private String lastName = "";
    private boolean isActive = false;
    private Role role;
    private int adminId;


    public User () {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Sign up Constructor
    public User(String username, String email, String password, String firstName, String lastName, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = false;
        this.role = role;
    }

    public User(int userId, String username, String password, String email, String firstName, String lastName, boolean isActive, Role role, int adminId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.role = role;
        this.adminId = adminId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", role=" + role +
                ", adminId=" + adminId +
                '}';
    }


    public void nullify() {
        this.setUserId(0);
        this.setUsername(null);
        this.setPassword(null);
        this.setEmail(null);
        this.setFirstName(null);
        this.setLastName(null);
        this.setActive(false);
        this.setRole(null);
    }

}
