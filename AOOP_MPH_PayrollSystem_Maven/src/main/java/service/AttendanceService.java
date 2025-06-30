package service;

import dao.AttendanceDAO;
import model.Attendance;
import java.sql.*;
import java.util.List;
import util.DBConnect;
import java.sql.SQLException;

public class AttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceService() throws SQLException

    {
        Connection conn = DBConnect.getConnection();
        this.attendanceDAO = new AttendanceDAO(conn);
    }

    public Attendance readAttendance(int id) throws SQLException {
        return attendanceDAO.getAttendance(id);
    }

    public void updateAttendance(Attendance att) throws SQLException {
        attendanceDAO.updateAttendance(att);
    }

    public void deleteAttendance(int id) throws SQLException {
        attendanceDAO.deleteAttendance(id);

    }

    public List<Attendance> listAllAttendance() throws SQLException {
        return attendanceDAO.getAllAttendanceRecords();
    }
}
