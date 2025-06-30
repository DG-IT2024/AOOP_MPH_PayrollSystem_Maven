package controller;

import model.LeaveRequest;
import service.LeaveService;

import java.sql.SQLException;
import java.util.List;

public class LeaveController {
    private LeaveService service;

    public LeaveController(LeaveService service) {
        this.service = service;
    }

    public void requestLeave(LeaveRequest leave) {
        try {
            service.applyForLeave(leave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LeaveRequest> getEmployeeLeaves(int employeeId) {
        try {
            return service.getLeaveHistory(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void approveLeave(int leaveId, int approverId) {
        try {
            service.approveLeave(leaveId, approverId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void denyLeave(int leaveId, int approverId) {
        try {
            service.denyLeave(leaveId, approverId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
