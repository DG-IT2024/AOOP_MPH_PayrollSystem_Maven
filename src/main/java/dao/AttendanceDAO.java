package dao;

import model.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

   
    private Connection conn;

    public AttendanceDAO(Connection conn) {
        this.conn = conn;
    }
    
   
    // Utility method to map a ResultSet row to an Attendance object
    private Attendance mapAttendance(ResultSet rs) throws SQLException {
        Attendance att = new Attendance();
        att.setAttendanceId(rs.getInt("attendance_id"));
        att.setEmployeeId(rs.getInt("employee_id"));
        att.setDate(rs.getDate("date"));
        att.setTimeIn(rs.getTime("time_in"));
        att.setTimeOut(rs.getTime("time_out"));
        att.setRegularHoursCalc(rs.getInt("regular_hours_calc"));
        return att;
    }
    
    
    private Attendance mapTimeSheet(ResultSet rs) throws SQLException {
        Attendance att = new Attendance();
        att.setDate(rs.getDate("date"));
        att.setTimeIn(rs.getTime("time_in"));
        att.setTimeOut(rs.getTime("time_out"));
        att.setRegularHoursCalc(rs.getInt("regular_hours_calc"));
        return att;
    }

//    public void addAttendance(Attendance att) throws SQLException {
//        String sql = "INSERT INTO attendance (employee_id, date, time_in, time_out, regular_hours_calc) VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, att.getEmployeeId());
//        stmt.setDate(2, att.getDate());
//        stmt.setTime(3, att.getTimeIn());
//        stmt.setTime(4, att.getTimeOut());
//        stmt.setInt(5, att.getRegularHoursCalc());
//        stmt.executeUpdate();
//    }
    public Attendance getAttendance(int attendanceId) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, attendanceId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Attendance(
                    rs.getInt("attendance_id"),
                    rs.getInt("employee_id"),
                    rs.getDate("date"),
                    rs.getTime("time_in"),
                    rs.getTime("time_out"),
                    rs.getInt("regular_hours_calc")
            );
        }
        return null;
    }

    public void updateAttendance(Attendance att) throws SQLException {
        String sql = "UPDATE attendance SET employee_id=?, date=?, time_in=?, time_out=?, regular_hours_calc=? WHERE attendance_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, att.getEmployeeId());
        stmt.setDate(2, att.getDate());
        stmt.setTime(3, att.getTimeIn());
        stmt.setTime(4, att.getTimeOut());
        stmt.setInt(5, att.getRegularHoursCalc());
        stmt.setInt(6, att.getAttendanceId());
        stmt.executeUpdate();
    }

    public void deleteAttendance(int attendanceId) throws SQLException {
        String sql = "DELETE FROM attendance WHERE attendance_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, attendanceId);
        stmt.executeUpdate();
    }

    public List<Attendance> getAllAttendanceRecords() throws SQLException {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                attendanceList.add(mapAttendance(rs));
            }
        }
        return attendanceList;
    }

// Get attendance record by ID
    public Attendance getAttendanceRecordById(int attendanceId) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, attendanceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapAttendance(rs);
                }
            }
        }
        return null;
    }

}
