package model;

import java.sql.Date;
import java.sql.Time;

public class Attendance {

    private int attendanceId;
    private int employeeId;
    private Date date;
    private Time timeIn;
    private Time timeOut;
    private int regularHoursCalc;

    public Attendance() {}

    public Attendance(int attendanceId, int employeeId, Date date, Time timeIn, Time timeOut, int regularHoursCalc) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.regularHoursCalc = regularHoursCalc;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }

    public int getRegularHoursCalc() {
        return regularHoursCalc;
    }

    public void setRegularHoursCalc(int regularHoursCalc) {
        this.regularHoursCalc = regularHoursCalc;
    }
}
