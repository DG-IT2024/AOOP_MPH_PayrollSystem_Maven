/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import service.*;

public class LoginTest {

    public static void main(String[] args) throws Exception {
        String inputUsername = "antonio_lim";
        String inputPassword = "hFmjDw7t"; // plaintext; assume hashed in actual Password table

        LoginService loginService = new LoginService();
        loginService.authenticate(inputUsername, inputPassword);


    }
}
