/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import service.EmployeeService;

/**
 *
 * @author danilo
 */
public class EmployeeTest {
    
   
 public static void main(String[] args) throws Exception {
    
        EmployeeService employeeService = new EmployeeService();
        employeeService.printAllEmployees();


    }
}
