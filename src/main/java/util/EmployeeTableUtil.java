package util;

import model.Employee;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EmployeeTableUtil {

    public static DefaultTableModel toTableModel(List<Employee> employees) {
        String[] columnNames = {
            "Employee ID", "Last Name", "First Name", "Birthdate", "Address", "Phone Number",
            "SSS Number", "TIN Number", "PhilHealth Number", "PagIbig Number", "Status", "Position", "Immediate Supervisor",
            "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (Employee emp : employees) {

            String address = String.format("%s; %s; %s; %s; %s",
                    emp.getStreet() != null ? emp.getStreet() : "",
                    emp.getBarangay() != null ? emp.getBarangay() : "",
                    emp.getCity() != null ? emp.getCity() : "",
                    emp.getProvince() != null ? emp.getProvince() : "",
                    emp.getZip() != null ? emp.getZip() : ""
            );

            String[] row = new String[]{
                String.valueOf(emp.getEmployeeId()),
                emp.getLastName(),
                emp.getFirstName(),
                emp.getBirthdate() == null ? "" : emp.getBirthdate().toString(),
                address, // <<== combined address here
                emp.getPhoneNumber(),
                emp.getSssNumber(),
                emp.getTinNumber(),
                emp.getPhilhealthNumber(),
                emp.getPagibigNumber(),
                emp.getStatus(),
                emp.getPosition(),
                emp.getImmediateSupervisor(),
                String.valueOf(emp.getBasicSalary()),
                String.valueOf(emp.getRiceSubsidy()),
                String.valueOf(emp.getPhoneAllowance()),
                String.valueOf(emp.getClothingAllowance())
            };
            model.addRow(row);
        }
        return model;

    }
    
   //If the cell’s value is null, it returns an empty string ("") instead of causing a NullPointerException
    public static String safeGetValue(DefaultTableModel model, int row, int col) {
        if (row < 0 || col < 0 || col >= model.getColumnCount()) {
            return "";
        }
        Object value = model.getValueAt(row, col);
        return (value != null) ? value.toString() : "";
    }
    
    
    public static boolean isEmployeeFieldsUnique(List<Employee> employees, String sssNum, String philhealthNum, String pagibigNum, String tinNum) {
        for (Employee emp : employees) {
            if (sssNum != null && sssNum.equals(emp.getSssNumber())) return false;
            if (philhealthNum != null && philhealthNum.equals(emp.getPhilhealthNumber())) return false;
            if (pagibigNum != null && pagibigNum.equals(emp.getPagibigNumber())) return false;
            if (tinNum != null && tinNum.equals(emp.getTinNumber())) return false;
        }
        return true;
    }

//    public static DefaultTableModel toTableModel(List<Employee> employees) {
//        String[] columnNames = {
//            "Employee ID", "Last Name", "First Name", "Birthdate", "Street", "Barangay", "City", "Province", "Zip", "Phone Number",
//            "SSS Number", "TIN Number", "PhilHealth Number", "PagIbig Number", "Status", "Position", "Immediate Supervisor",
//            "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance"
//        };
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//        for (Employee emp : employees) {
//            String[] row = new String[]{
//                String.valueOf(emp.getEmployeeId()),
//                emp.getLastName(),
//                emp.getFirstName(),
//                emp.getBirthdate() == null ? "" : emp.getBirthdate().toString(),
//                emp.getStreet(),
//                emp.getBarangay(),
//                emp.getCity(),
//                emp.getProvince(),
//                emp.getZip(),
//                emp.getPhoneNumber(),
//                emp.getSssNumber(),
//                emp.getPhilhealthNumber(),
//                emp.getPagibigNumber(),
//                emp.getTinNumber(),
//                emp.getStatus(),
//                emp.getPosition(),
//                emp.getImmediateSupervisor(),
//                String.valueOf(emp.getBasicSalary()),
//                String.valueOf(emp.getRiceSubsidy()),
//                String.valueOf(emp.getPhoneAllowance()),
//                String.valueOf(emp.getClothingAllowance())
//            };
//            model.addRow(row);
//        }
//        return model;
//    }
}
