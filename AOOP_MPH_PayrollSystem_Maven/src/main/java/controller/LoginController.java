/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.LoginService;
import java.util.List;

public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean processLogin(String username, String password) {
        try {
            return loginService.authenticate(username, password);
        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public List<String> getPermissions(String username) {
        try {
            return loginService.getUserPermissions(username);
        } catch (Exception e) {
            System.err.println("Permission fetch error: " + e.getMessage());
            return List.of();
        }
    }
}
