/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author danilo
 */
public class Employee {

    private int employeeId;
    private String lastName;
    private String firstName;
    private Date birthdate;
    private String street;
    private String barangay;
    private String city;
    private String province;
    private String zip;
    private String phoneNumber;
    private String sssNumber;
    private String tinNumber;
    private String philhealthNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public void setPagibigNumber(String pagibigNumber) {
        this.pagibigNumber = pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public void setImmediateSupervisor(String immediateSupervisor) {
        this.immediateSupervisor = immediateSupervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", birthdate=" + birthdate
                + ", street='" + street + '\''
                + ", barangay='" + barangay + '\''
                + ", city='" + city + '\''
                + ", province='" + province + '\''
                + ", zip='" + zip + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", sssNumber='" + sssNumber + '\''
                + ", tinNumber='" + tinNumber + '\''
                + ", philhealthNumber='" + philhealthNumber + '\''
                + ", pagibigNumber='" + pagibigNumber + '\''
                + ", status='" + status + '\''
                + ", position='" + position + '\''
                + ", immediateSupervisor='" + immediateSupervisor + '\''
                + ", basicSalary=" + basicSalary
                + ", riceSubsidy=" + riceSubsidy
                + ", phoneAllowance=" + phoneAllowance
                + ", clothingAllowance=" + clothingAllowance
                + '}';
    }

}
