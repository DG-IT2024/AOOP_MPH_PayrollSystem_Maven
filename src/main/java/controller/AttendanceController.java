package controller;

import service.AttendanceService;
import model.Attendance;
import java.sql.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.AttendanceUtil;
import util.EmployeeTableUtil;

public class AttendanceController {

    private AttendanceService service;

    public AttendanceController(AttendanceService service) {
           this.service = service;
    }   
       
    
    public void loadAttendanceToTable(JTable table) {
        try {
            List<Attendance> attendance = service.listAllAttendance();
            DefaultTableModel model = AttendanceUtil.toTableModel(attendance);
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Attendance getAttendance(int id) {
        try {
            return service.readAttendance(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyAttendance(Attendance att) {
        try {
            service.updateAttendance(att);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAttendance(int id) {
        try {
            service.deleteAttendance(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
