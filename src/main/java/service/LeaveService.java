package service;

import dao.LeaveRequestDAO;
import model.LeaveRequest;
import java.sql.SQLException;
import java.util.List;

public class LeaveService {
    private LeaveRequestDAO dao;

    public LeaveService(LeaveRequestDAO dao) {
        this.dao = dao;
    }

    public void applyForLeave(LeaveRequest leave) throws SQLException {
        leave.setStatus("PENDING");
        leave.setRequestDate(new java.util.Date());
        leave.setLastUpdate(new java.util.Date());
        dao.createLeaveRequest(leave);
    }

    public List<LeaveRequest> getLeaveHistory(int employeeId) throws SQLException {
        return dao.getLeaveRequestsByEmployee(employeeId);
    }

    public void approveLeave(int leaveId, int approverId) throws SQLException {
        dao.updateLeaveRequestStatus(leaveId, "APPROVED", approverId);
    }

    public void denyLeave(int leaveId, int approverId) throws SQLException {
        dao.updateLeaveRequestStatus(leaveId, "DENIED", approverId);
    }
}
