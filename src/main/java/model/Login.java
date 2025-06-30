/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class Login {
    private int loginId;
    private String username;
    private int employeeId;
    private Timestamp lastLogin;
    private int noAttempts;

    // Constructor
    public Login() {}

    // Getters and Setters
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getNoAttempts() {
        return noAttempts;
    }

    public void setNoAttempts(int noAttempts) {
        this.noAttempts = noAttempts;
    }

//    // Optional: toString()
//    @Override
//    public String toString() {
//        return "Login{" +
//                "loginId=" + loginId +
//                ", username='" + username + '\'' +
//                ", employeeId=" + employeeId +
//                ", lastLogin=" + lastLogin +
//                ", noAttempts=" + noAttempts +
//                '}';
//    }

}
