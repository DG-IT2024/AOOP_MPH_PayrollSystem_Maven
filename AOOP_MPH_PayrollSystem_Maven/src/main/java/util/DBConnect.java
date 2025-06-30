/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;

public class DBConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/payrollsystem_db"; // Update schema name
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/your_schema"; // Change to your schema name!
//        String user = "root";
//        String password = "password";
//
//        try {
//            Connection conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to database!");
//            
//            
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Connection failed!");
//            e.printStackTrace();
//          }
//    }

//     public static void main(String[] args) {
//        // Database connection details
//        String url = "jdbc:mysql://localhost:3306/motorph_db";
//        String user = "root";
//        String password = "password";
//
//        String query = "SELECT login_id, username, employee_id, last_login FROM login";
//
//        try (
//            Connection conn = DriverManager.getConnection(url, user, password);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query)
//        ) {
//            System.out.println("login_id\tusername\t\temployee_id\tlast_login");
//            while (rs.next()) {
//                int loginId = rs.getInt("login_id");
//                String username = rs.getString("username");
//                int employeeId = rs.getInt("employee_id");
//                Timestamp lastLogin = rs.getTimestamp("last_login");
//
//                System.out.printf("%d\t\t%s\t\t%d\t\t%s%n",
//                    loginId, username, employeeId, lastLogin);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }