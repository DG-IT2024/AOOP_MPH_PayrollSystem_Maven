package util;

public class LeaveStatusUtil {
    public static boolean isValidStatus(String status) {
        return "PENDING".equals(status) || "APPROVED".equals(status) || "DENIED".equals(status);
    }
}
