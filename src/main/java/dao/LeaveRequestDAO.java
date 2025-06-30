package dao;

import model.LeaveRequest;
import java.sql.*;
import java.util.*;

public class LeaveRequestDAO {
    private Connection conn;

    public LeaveRequestDAO(Connection conn) {
        this.conn = conn;
    }

    public void createLeaveRequest(LeaveRequest leave) throws SQLException {
        String sql = "INSERT INTO Leave_Request (employee_id, leave_type_id, start_date, end_date, calc_leave, reason, request_date, status, approver_id, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, leave.getEmployeeId());
            stmt.setInt(2, leave.getLeaveTypeId());
            stmt.setDate(3, new java.sql.Date(leave.getStartDate().getTime()));
            stmt.setDate(4, new java.sql.Date(leave.getEndDate().getTime()));
            stmt.setInt(5, leave.getCalcLeave());
            stmt.setString(6, leave.getReason());
            stmt.setTimestamp(7, new java.sql.Timestamp(leave.getRequestDate().getTime()));
            stmt.setString(8, leave.getStatus());
            stmt.setObject(9, leave.getApproverId(), java.sql.Types.INTEGER);
            stmt.setTimestamp(10, new java.sql.Timestamp(leave.getLastUpdate().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<LeaveRequest> getLeaveRequestsByEmployee(int employeeId) throws SQLException {
        String sql = "SELECT * FROM Leave_Request WHERE employee_id = ?";
        List<LeaveRequest> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LeaveRequest leave = mapResultSetToLeaveRequest(rs);
                list.add(leave);
            }
        }
        return list;
    }

    public void updateLeaveRequestStatus(int leaveId, String status, int approverId) throws SQLException {
        String sql = "UPDATE Leave_Request SET status = ?, approver_id = ?, last_update = NOW() WHERE leave_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, approverId);
            stmt.setInt(3, leaveId);
            stmt.executeUpdate();
        }
    }

    private LeaveRequest mapResultSetToLeaveRequest(ResultSet rs) throws SQLException {
        LeaveRequest leave = new LeaveRequest();
        leave.setLeaveId(rs.getInt("leave_id"));
        leave.setEmployeeId(rs.getInt("employee_id"));
        leave.setLeaveTypeId(rs.getInt("leave_type_id"));
        leave.setStartDate(rs.getDate("start_date"));
        leave.setEndDate(rs.getDate("end_date"));
        leave.setCalcLeave(rs.getInt("calc_leave"));
        leave.setReason(rs.getString("reason"));
        leave.setRequestDate(rs.getTimestamp("request_date"));
        leave.setStatus(rs.getString("status"));
        leave.setApproverId(rs.getObject("approver_id") == null ? null : rs.getInt("approver_id"));
        leave.setLastUpdate(rs.getTimestamp("last_update"));
        return leave;
    }
}
