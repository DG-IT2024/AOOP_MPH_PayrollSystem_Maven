/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.EmployeeDAO;
import java.sql.Connection;
import model.Employee;
import java.sql.SQLException;
import java.util.List;
import util.DBConnect;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService() throws Exception {

        Connection conn = DBConnect.getConnection();
        this.employeeDAO = new EmployeeDAO(conn);
    }

    public Employee findEmployeeById(int id) throws SQLException {
        return employeeDAO.getEmployeeDetailsById(id);
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDAO.createEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDAO.updateEmployee(employee);
    }

    public void removeEmployee(int id) throws SQLException {
        employeeDAO.deleteEmployee(id);
    }

    public List<Employee> listAllEmployees() throws SQLException {
        return employeeDAO.getAllEmployees();
    }

    public void printAllEmployees() {
        try {
            List<Employee> employees = employeeDAO.getAllEmployees(); // call the method in this class
            for (Employee emp : employees) {
                System.out.println(emp); // Will use Employee's toString()
            }
        } catch (Exception e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

}
