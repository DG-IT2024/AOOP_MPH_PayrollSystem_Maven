package util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import model.Attendance;

public class AttendanceUtil {
    
    public static DefaultTableModel toTableModel(List<Attendance> attendanceList) {
        String[] columnNames = {
            "Attendance ID", "Employee ID", "Date", "Time In", "Time Out", "Regular Hours"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Attendance att : attendanceList) {
            String[] row = new String[]{
                String.valueOf(att.getAttendanceId()),
                String.valueOf(att.getEmployeeId()),
                att.getDate() != null ? att.getDate().toString() : "",
                att.getTimeIn() != null ? att.getTimeIn().toString() : "",
                att.getTimeOut() != null ? att.getTimeOut().toString() : "",
                String.valueOf(att.getRegularHoursCalc())
            };
            model.addRow(row);
        }

        return model;
    }

    public static int calculateWorkedHours(String timeIn, String timeOut) {
        LocalTime parsedTimeIn = LocalTime.parse(timeIn);
        LocalTime parsedTimeOut = LocalTime.parse(timeOut);

        int gracePeriod = 10;
        LocalTime officeStart = LocalTime.of(8, 0);
        LocalTime targetTime = LocalTime.of(8, gracePeriod + 1);

        if (parsedTimeIn.isBefore(targetTime) && parsedTimeIn.getHour() == officeStart.getHour()) {
            parsedTimeIn = officeStart;
        }

        LocalTime breakStart = LocalTime.of(12, 0);
        LocalTime breakEnd = LocalTime.of(13, 0);

        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isBefore(LocalTime.of(12, 59))) {
            parsedTimeOut = breakStart;
        }
        if (parsedTimeIn.isAfter(LocalTime.of(11, 59)) && parsedTimeOut.isAfter(breakEnd)) {
            parsedTimeIn = breakEnd;
        }

        int totalMinutesIn = parsedTimeIn.getHour() * 60 + parsedTimeIn.getMinute();
        int totalMinutesOut = parsedTimeOut.getHour() * 60 + parsedTimeOut.getMinute();
        int workedMinutes = totalMinutesOut - totalMinutesIn;
        int workedHour = workedMinutes / 60;

        int breakTime = 0;
        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isAfter(LocalTime.of(12, 59))) {
            breakTime = 1;
        }
        if (parsedTimeIn.equals(breakStart) && parsedTimeOut.equals(breakEnd)) {
            breakTime = 1;
        }

        return workedHour - breakTime;
    }

    public static Integer regularWorkedHours(ArrayList<Integer> regularHoursList) {
        int totalRegularHour = 0;
        for (Integer hour : regularHoursList) {
            totalRegularHour += hour;
        }
        return totalRegularHour;
    }

    public static Integer overtimeHours(ArrayList<Integer> overtimeHoursList) {
        int totalOvertimeHour = 0;
        for (Integer hour : overtimeHoursList) {
            totalOvertimeHour += hour;
        }
        return totalOvertimeHour;
    }

    public static void regularOvertimeView(int workedregularHours, int workedOvertimeHours) {
        System.out.println("-".repeat(55));
        System.out.println("Regular Hours : " + workedregularHours);
        System.out.println("Overtime Hours : " + workedOvertimeHours);
        System.out.println("-".repeat(55));
    }

    public static double overtimeRateInput() {
        Scanner overtimeRateEntry = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nEnter Overtime Pay rate: (Example 1.25)");
                System.out.println("(Set rate to 0 if you don't want to credit overtime hours)");
                double overtimeRate = Double.parseDouble(overtimeRateEntry.nextLine());

                if (overtimeRate < 0) {
                    System.out.println("--- Error: Invalid Input. Overtime rate must be non-negative. ---");
                    continue;
                }
                if (overtimeRate > 0 && overtimeRate < 1) {
                    System.out.println("--- Error: Invalid Input. Overtime rate must be greater than 1. ---");
                    continue;
                }
                return overtimeRate;
            } catch (NumberFormatException e) {
                System.out.println("--- Error: Invalid Input. Please enter a valid number. ---");
            }
        }
    }

    public static double weightedOvertimeHour(ArrayList<Integer> overtimeHoursList, ArrayList<Double> overtimeRateList) {
        double overtimeHourPay = 0;
        for (int i = 0; i < overtimeHoursList.size(); i++) {
            overtimeHourPay += overtimeHoursList.get(i) * overtimeRateList.get(i);
        }
        return overtimeHourPay;
    }

    public static boolean isValidTimeFormat(String time) {
        return time.matches("\\d{2}:\\d{2}") || time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }
}
