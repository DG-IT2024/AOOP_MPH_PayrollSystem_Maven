/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author danilo
 */
import dao.LoginDAO;
import model.Login;
import model.Password;

import model.Permission;
import util.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

    private static final int MAX_ATTEMPTS = 3;
    private Map<String, Integer> userAttempts = new HashMap<>();
    private LoginDAO loginDAO;

    public LoginService() throws Exception {

        Connection conn = DBConnect.getConnection();
        this.loginDAO = new LoginDAO(conn);
    }

//    public boolean authenticate(String username, String rawPassword) throws Exception {
//        Login login = loginDAO.getLoginByUsername(username);
//        if (login == null) return false;
//        Password pw = loginDAO.getPasswordByLoginId(login.getLoginId());
//        return rawPassword.equals(pw.getPasswordSaltHash()); // Replace with BCrypt in production
//    }
//    public boolean authenticate(String username, String rawPassword) throws Exception {
//        Login login = loginDAO.getLoginByUsername(username);
//        if (login == null) {
//            return false;
//        }
//
//        Password pw = loginDAO.getPasswordByLoginId(login.getLoginId());
//
//        return BCrypt.checkpw(rawPassword, pw.getPasswordSaltHash());
//
//    }
    public boolean authenticate(String username, String rawPassword) throws Exception {

        Login login = loginDAO.getLoginByUsername(username);

        //// Step 1: Check if username exists
        if (login == null) {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

//        // Debug login_id
//        System.out.println("Login ID: " + login.getLoginId());
        //// Step 2: Check if account has exceed maximum login_attempts
        if (isBlocked(username)) {
            JOptionPane.showMessageDialog(null, "Account is blocked due to too many failed login attempts.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //// Step 3: Get hashed password by login ID
        Password pw = loginDAO.getPasswordByLoginId(login.getLoginId());
        if (pw == null || pw.getPasswordSaltHash() == null) {
//            System.out.println("No password record found for user");
            return false;
        }

//        // Debug password_id and password_salt_hash
//        System.out.println("Password ID: " + pw.getPasswordId());
//        System.out.println("Entered Password: " + rawPassword);
//        System.out.println("Password Hash from DB: " + pw.getPasswordSaltHash());
        //// Step 4: Compare using BCrypt
        boolean match = checkPassword(rawPassword, pw.getPasswordSaltHash());

        if (match) {
            loginDAO.resetLoginAttempts(username);
        } else {
            loginDAO.incrementLoginAttempts(username);
            if (isBlocked(username)) {
                // Blocked *after* this last attempt
                JOptionPane.showMessageDialog(null, "Account is now blocked due to too many failed login attempts.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Not yet blocked, show generic invalid message
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

//        //        boolean match = BCrypt.checkpw(rawPassword, pw.getPasswordSaltHash());
//        System.out.println("Password match: " + match);
        return match;
    }

    // Check if user is blocked
    public boolean isBlocked(String username) throws Exception {
        Login login = loginDAO.getLoginByUsername(username);
        if (login == null) {
            return false; // user not found, treat as not blocked to allow error handling in authenticate()
        }
//        System.out.println("no. of attempts = " + login.getNoAttempts());
        return login.getNoAttempts() >= MAX_ATTEMPTS;
    }

    // check if input password match the stored password 
    public boolean checkPassword(String inputPassword, String storedHashedPassword) {
        return BCrypt.checkpw(inputPassword, storedHashedPassword);
    }

    public List<String> getUserPermissions(String username) throws Exception {
        Login login = loginDAO.getLoginByUsername(username);
        if (login == null) {
            return Collections.emptyList();
        }
        List<Permission> perms = loginDAO.getPermissionsByLoginId(login.getLoginId());
        List<String> names = new ArrayList<>();
        for (Permission p : perms) {
            names.add(p.getPermissionName());
        }
        return names;
    }
}
