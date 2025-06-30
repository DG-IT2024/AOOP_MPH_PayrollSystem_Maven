/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danilo
 */
import java.util.Date;

public class LeaveRequest {

    private int leaveId;
    private int employeeId;
    private int leaveTypeId;
    private Date startDate;
    private Date endDate;
    private int calcLeave;
    private String reason;
    private Date requestDate;
    private String status; // PENDING, APPROVED, DENIED
    private Integer approverId;
    private Date lastUpdate;

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public int getCalcLeave() {
        return calcLeave;
    }

    public void setCalcLeave(int calcLeave) {
        this.calcLeave = calcLeave;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public java.util.Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(java.util.Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
