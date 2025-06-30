package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // Convert Object (Date or String) to java.util.Date
    public static Date convertToDate(Object dateObj) throws ParseException {
        if (dateObj instanceof Date) {
            return (Date) dateObj;
        } else if (dateObj instanceof String) {
            String[] formats = {"MM/dd/yyyy", "yyyy-MM-dd"};
            ParseException lastException = null;
            for (String fmt : formats) {
                try {
                    return new SimpleDateFormat(fmt).parse((String) dateObj);
                } catch (ParseException e) {
                    lastException = e;
                }
            }
            throw lastException != null ? lastException
                    : new ParseException("Unparseable date: " + dateObj, 0);
        } else {
            throw new ParseException("Unparseable date: " + dateObj, 0);
        }
    }

    // Convert java.util.Date to formatted String (for display)
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    // Convert java.util.Date to default string "MM/dd/yyyy"
    public static String dateToDefaultString(Date date) {
        return dateToString(date, "MM/dd/yyyy");
    }

    // Convert java.util.Date to java.sql.Date
    public static java.sql.Date utilDateToSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    // Convert java.sql.Date to java.util.Date (actually same in most cases, but for clarity)
    public static Date sqlDateToUtilDate(java.sql.Date sqlDate) {
        return sqlDate == null ? null : new Date(sqlDate.getTime());
    }

    // Compare two dates (ignoring time)
    public static boolean isSameDay(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(d1).equals(fmt.format(d2));
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }

}
