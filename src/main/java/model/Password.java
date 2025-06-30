/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danilo
 */
public class Password {

    private int passwordId;
    private int loginId;
    private String passwordSaltHash;

    public int getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(int passwordId) {
        this.passwordId = passwordId;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getPasswordSaltHash() {
        return passwordSaltHash;
    }

    public void setPasswordSaltHash(String passwordSaltHash) {
        this.passwordSaltHash = passwordSaltHash;
    }
}

