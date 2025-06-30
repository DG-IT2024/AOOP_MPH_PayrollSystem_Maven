package controller;

import model.Employee;
import service.EmployeeService;
import util.EmployeeTableUtil;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    public void loadEmployeesToTable(JTable table) {
        try {
            List<Employee> employees = service.listAllEmployees();
            DefaultTableModel model = EmployeeTableUtil.toTableModel(employees);
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees()throws SQLException {
         List<Employee> employees = service.listAllEmployees();
         
         return employees;
    }

    public void addEmployee(Employee employee) {
        try {
            service.addEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            service.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int employeeId) {
        try {
            service.removeEmployee(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
