package com.ancel.test.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
 
public class DateUtil {
 
    /**
     * 日期格式化字符串->全数字表示
     */
    public static final String TIME_FORMAT_DIGITAL = "yyyyMMddHHmmss";
 
    /**
     * 日期格式化字符串 到秒
     */
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
 
    /**
     * 日期格式化字符串 到毫秒
     */
    public static final String TIME_FORMAT_MSEL = "yyyy-MM-dd HH:mm:ss.SSS";
 
    /**
     * oracle中日期格式化字符串
     */
    public static final String TIME_FORMAT_ORACLE = "yyyy-MM-dd hh24:mi:ss";
 
    /**
     * 订单专用日期格式化字符串
     */
    public static final String TIME_FORMAT_ORDER = "yyyyMMdd";
 
    /**
     * 获取服务器当前日期
     * @return
     */
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
 
    /**
     * 获取服务器当前时间的字符串 ,格式 ：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentDateStr(){
 
        return convertDateToStr(getCurrentDate(), TIME_FORMAT);
    }
 
    /**
     * 获取服务器当前时间的字符串到毫秒 ,格式 ：yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static String getCurrentTimeStr(){
 
        return convertDateToStr(getCurrentDate(), TIME_FORMAT_MSEL);
    }
 
    public static String getOrderDateStr(){
        return convertDateToStr(new Date(),TIME_FORMAT_ORDER);
    }
 
    /**
     * 增加天数
     * @param date
     * @param days
     * @return
     */
    public static Date addDate(Date date, int days) {
        if (date == null) return date;
        Locale loc = Locale.getDefault();
        GregorianCalendar cal = new GregorianCalendar(loc);
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        cal.set(year, month, day + days);
        return cal.getTime();
    }
 
    /**
     * 将字符串转换为日期格式
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date convertStrToDate(String dateStr, String dateFormat) {
        if (dateStr == null || dateStr.equals("")) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateStr);
        }
        catch (Exception e) {
            throw new RuntimeException("DateUtil.convertStrToDate():" + e.getMessage());
        }
    }
 
    /**
     * 将日期转换为字符串格式
     * @param date
     * @param dateFormat
     * @return
     */
    public static String convertDateToStr(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
 
    /**
     * 将日期转换为字符串格式
     * @param date
     * @param dateFormat
     * @return
     */
    public static String convertDateToStr(Date date) {
        return convertDateToStr(date,TIME_FORMAT);
    }
 
    /**
     * 给一日期增加一时间
     * @param timePart HH,mm,ss
     * @param number 要增加的时间
     * @param date 日期对象
     * @return
     */
    public static Date addTime(String timePart, int number, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (timePart.equals("HH")) {
            cal.add(Calendar.HOUR, number);
        }
        else if (timePart.equals("mm")) {
            cal.add(Calendar.MINUTE, number);
        }
        else if (timePart.equals("ss")) {
            cal.add(Calendar.SECOND, number);
        }
        else {
            throw new IllegalArgumentException("DateUtil.addDate()方法非法参数值：" + timePart);
        }
        return cal.getTime();
    }
 
    /**
     *
     * 清除指定的时间
     * @param date
     * @param timePart HH,mm,ss
     * @return
     */
    public static Date clearTime(Date date,String timePart){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (timePart.equals("HH")) {
            cal.clear(Calendar.HOUR);
        }
        else if (timePart.equals("mm")) {
            cal.clear(Calendar.MINUTE);
        }
        else if (timePart.equals("ss")) {
            cal.clear(Calendar.SECOND);
        }
        else {
            throw new IllegalArgumentException("DateUtil.addDate()方法非法参数值：" + timePart);
        }
        return cal.getTime();
    }
 
    /**
     *  时间格式转化
     * @param dateStr
     * @param formatStyle
     * @return Date
     * @author:sunjiaxiao
     * @date:2013-3-29
    */
    public static Date getDate(String dateStr,String formatStyle){
        DateFormat df = new SimpleDateFormat(formatStyle);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
 
    public static Date getDate(String dateStr){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
 
    /**
     *  获取date格式化后的字符串
     * @param formatStyle
     * @return String
     * @author:sunjiaxiao
     * @date:2013-4-25
    */
    public static String getDateStr (String formatStyle){
        DateFormat df = new SimpleDateFormat(formatStyle);
        return df.format(new Date());
    }
}