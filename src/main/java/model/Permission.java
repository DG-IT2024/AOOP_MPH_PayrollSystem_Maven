/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danilo
 */
public class Permission {
    private int permissionId;
    private String permissionName;
    private String description;

    // Constructor
    public Permission() {}

    // Getters and Setters
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optional: toString()
//    @Override
//    public String toString() {
//        return "Permission{" +
//                "permissionId=" + permissionId +
//                ", permissionName='" + permissionName + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
