package com.ardhiart;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Hinata on 10/16/2017.
 */
public class DateUtils {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public static String dateToStringISO8601(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(date);
    }

    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = System.currentTimeMillis();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return diff / DAY_MILLIS + " days ago";
        }
    }

    public static String toNormalHourGMT(String timestamp){
        return toNormalHour(toGMT(timestamp));
    }

    public static String toNormalHour(String timestamp) {
        Date date = new Date();
        String currDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(new Date());
        String now = "" + new Timestamp(date.getTime());
        String timeStampGMT = toGMT(timestamp);
        return toHours_HH_MM(timestamp, ":");

    }

    private static String toGMT(String timestamp) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        String servertime = toYear(timestamp) + "-" + toMounth(timestamp) + "-" + toDay(timestamp) + " " + toHours_HH_MM(timestamp, ":") + ":" + toSec(timestamp) + "." + toMilSec(timestamp) + " GMT";
        Date date = null;
        long epoch = 0;
        long epochServer = 0;

        try {
            date = df.parse(df.format(new Date()));
            epoch = date.getTime();
            epochServer = df.parse(servertime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calGMT(epochServer);
    }

    public static String toHours_HH_MM(String timestamp, String dividing) {
        if (timestamp.length() < 19) return timestamp;

        return toHours(timestamp) + dividing + toMinutes(timestamp);
    }

    public static String calGMT(long serverTime) {
        long offsetInMillis = getCurrentTimezoneOffset();
        long server = serverTime;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        String res = df.format(new Date(server));
        return res;
    }

    public static String toMounth(String timestamp) {
        if (timestamp.length() < 7) return "00";
        return timestamp.substring(5, 7);
    }

    public static String toDay(String timestamp) {
        if (timestamp.length() < 10) return "00";
        return timestamp.substring(8, 10);
    }

    public static String toYear(String timestamp) {
        if (timestamp.length() < 4) return "00";
        return timestamp.substring(0, 4);
    }

    public static String toHours(String timestamp) {
        if (timestamp.length() < 13) return "00";
        return timestamp.substring(11, 13);
    }

    public static String toMinutes(String timestamp) {
        if (timestamp.length() < 16) return "00";
        return timestamp.substring(14, 16);
    }

    public static String toSec(String timestamp) {
        if (timestamp.length() < 19) return "00";
        return timestamp.substring(17, 19);
    }

    public static String toMilSec(String timestamp) {
        if (timestamp.length() < 19) return "00";
        return timestamp.substring(20, 23);
    }

    public static int getCurrentTimezoneOffset() {

        TimeZone tz = TimeZone.getDefault();
        Calendar cal = GregorianCalendar.getInstance(tz);
        int offsetInMillis = tz.getOffset(cal.getTimeInMillis());
        String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
        return offsetInMillis;
    }

    public static String toDateYMD(String timestamp){
        String tm = toGMT(timestamp);
        return toYear(tm)+"-"+toMounth(tm)+"-"+toDay(tm);
    }

    public static String toNormal(String time){
       String tanggal = "";
//        2017-07-07T00:00:00+07:00"
        tanggal += time.substring(0,10);
        tanggal += " ";
        tanggal += time.substring(11,15);
        return tanggal;
    }

}
