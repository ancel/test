package com.ancel.test.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ValidateUtil {
 
    // 日期表达式
    private static final String REG_EXT = "^([1-9]\\d{3})((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))(([0-1][0-9])|(2[0-3]))([0-5][0-9])([0-5][0-9])$";
 
    // 手机表达式
    private static final String REG_PHONE = "^(13\\d{9})|(15[0-35-9]\\d{8})|(18[05-9]\\d{8})$";
 
    // 昵称表达式
    private static final String REG_NICKNAME = "^[a-zA-Z0-9]{4,16}$";
 
    // 邮箱表达式
    private static final String REG_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
 
    //验证版本
    private static final String REG_VERSION = "^[0-9]+(.[0-9]{1,2})?$";
 
    // MD5值格式
    private static final String REG_MD5 = "^[a-zA-Z0-9]{32}$";
 
    // 中文真实姓名格式
    private static final String REG_REALNAME = "^[\u4E00-\u9FA5]{2,8}$";
 
    // 数字格式
    private static final String REG_NUMBER = "^\\d+$";
 
    // 时间戳格式
    private static final String REG_TIMESTAMP = "^\\d{13}$";
 
    // IP格式
    private static final String REG_IP = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";
 
    // MAC地址格式
    private static final String REG_MAC = "^[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}$";
 
    /**
     * 验证数字格式(只能为0-9的值)
     *
     * @param value
     * @return
     */
    public static boolean validateNumber(String value) {
        return RegExtUtil.matcher(REG_NUMBER, value);
    }
 
    /**
     * 验证数字格式
     *
     * @param value
     * @return
     */
    public static boolean validateNumAndLen(String value, int minLen, int maxLen) {
        boolean flag = RegExtUtil.matcher(REG_NUMBER, value);
        if (flag) {
            if (value.length() >= minLen && value.length() <= maxLen) {
                return true;
            }
        }
 
        return false;
    }
 
    /**
     * 验证真实名称格式
     *
     * @param realName
     * @return
     */
    public static boolean validateRealName(String realName) {
        return RegExtUtil.matcher(REG_REALNAME, realName);
    }
 
    /**
     * 验证昵称格式
     *
     * @param realName
     * @return
     */
    public static boolean validateNickName(String nickName) {
        return RegExtUtil.matcher(REG_NICKNAME, nickName);
    }
 
    /**
     * 验证邮箱格式
     *
     * @param realName
     * @return
     */
    public static boolean validateEmail(String email) {
        return RegExtUtil.matcher(REG_EMAIL, email);
    }
 
    /**
     * 验证手机格式
     *
     * @param realName
     * @return
     */
    public static boolean validatePhone(String phone) {
        return RegExtUtil.matcher(REG_PHONE, phone);
    }
 
    /**
     * 验证MD5加密后密码格式
     *
     * @param passWord
     * @return
     */
    public static boolean validateMD5Value(String value) {
        return RegExtUtil.matcher(REG_MD5, value);
    }
 
    /**
     * 验证版本
     * 
     * @param value
     * @return boolean
     * @author:黄彦军
     * @date:2013-4-8
    *
     */
    public static boolean validateVersion(String value){
        return RegExtUtil.matcher(REG_VERSION, value);
    }
 
    /**
     * 验证时间戳
     * 
     * @param value
     * @return boolean
     * @author:黄彦军
     * @date:2013-4-8
    *
     */
    public static boolean validateTimeStamp(String value){
        return RegExtUtil.matcher(REG_TIMESTAMP, value);
    }
 
    /**
     * 验证IP格式
     *
     * @param ip
     * @return
     */
    public static boolean validateIp(String ip) {
        return RegExtUtil.matcher(REG_IP, ip);
    }
 
    /**
     * 验证Mac地址格式
     */
    public static boolean validateMacAddress(String macAddress) {
        return RegExtUtil.matcher(REG_MAC, macAddress);
    }
 
    /**
     * 验证身份证号码格式
     *
     * @param idCard
     * @return
     */
    public static boolean validateIdCard(String idCard) {
 
        String idcard = idCard.toUpperCase();
        String JYM;
        int Y, S;
        String M;
        String ereg;
 
        String[] idcard_array = new String[] {};
        String[] idcard_list = new String[18];
        idcard_array = idcard.split("");
        int i = 0;
        for (String string : idcard_array) {
            if (!"".equals(string)) {
                idcard_list[i] = string;
                i++;
            }
        }
        if (getTopIDCard(Integer.parseInt(idcard.substring(0, 2))) == null) {
            return false;
        }
        switch (idcard.length()) {
        case 15:
            int idcardsub15 = Integer.parseInt(idcard.substring(6, 8));
            if ((idcardsub15 + 1900) % 4 == 0
                    || ((idcardsub15 + 1900) % 100 == 0 && (idcardsub15 + 1900) % 4 == 0)) {
                ereg = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$";// 测试出生日期的合法性
            } else {
                ereg = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$";// 测试出生日期的合法性
            }
            return RegExtUtil.matcher(ereg, idCard);
        case 18:
            int idcardsub18 = Integer.parseInt(idcard.substring(6, 10));
            if (idcardsub18 % 4 == 0 || (idcardsub18 % 100 == 0 && idcardsub18 % 4 == 0)) {
                ereg = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$";// 闰年出生日期的合法性正则表达式
            } else {
                ereg = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$";// 平年出生日期的合法性正则表达式
            }
            if (RegExtUtil.matcher(ereg, idCard)) {
                S = (Integer.parseInt(idcard_list[0]) + Integer.parseInt(idcard_list[10])) * 7
                        + (Integer.parseInt(idcard_list[1]) + Integer.parseInt(idcard_list[11]))
                        * 9
                        + (Integer.parseInt(idcard_list[2]) + Integer.parseInt(idcard_list[12]))
                        * 10
                        + (Integer.parseInt(idcard_list[3]) + Integer.parseInt(idcard_list[13]))
                        * 5
                        + (Integer.parseInt(idcard_list[4]) + Integer.parseInt(idcard_list[14]))
                        * 8
                        + (Integer.parseInt(idcard_list[5]) + Integer.parseInt(idcard_list[15]))
                        * 4
                        + (Integer.parseInt(idcard_list[6]) + Integer.parseInt(idcard_list[16]))
                        * 2 + Integer.parseInt(idcard_list[7]) * 1
                        + Integer.parseInt(idcard_list[8]) * 6 + Integer.parseInt(idcard_list[9])
                        * 3;
                Y = S % 11;
                M = "F";
                JYM = "10X98765432";
                M = JYM.substring(Y, Y + 1);
                if (M.equals(idcard_list[17])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        default:
            return false;
        }
    }
 
    /**
     * 身份证组装
     *
     * @param idcard
     * @return String
     *
     */
    private static String getTopIDCard(int idcard) {
        Map<Integer, String> areaMap = new HashMap<Integer, String>();
        areaMap.put(11, "北京");
        areaMap.put(12, "天津");
        areaMap.put(13, "河北");
        areaMap.put(14, "山西");
        areaMap.put(15, "内蒙古");
        areaMap.put(21, "辽宁");
        areaMap.put(22, "吉林");
        areaMap.put(23, "黑龙江");
        areaMap.put(31, "上海");
        areaMap.put(32, "江苏");
        areaMap.put(33, "浙江");
        areaMap.put(34, "安徽");
        areaMap.put(35, "福建");
        areaMap.put(36, "江西");
        areaMap.put(37, "山东");
        areaMap.put(41, "河南");
        areaMap.put(42, "湖北");
        areaMap.put(43, "湖南");
        areaMap.put(44, "广东");
        areaMap.put(45, "广西");
        areaMap.put(46, "海南");
        areaMap.put(50, "重庆");
        areaMap.put(51, "四川");
        areaMap.put(52, "贵州");
        areaMap.put(53, "云南");
        areaMap.put(54, "西藏");
        areaMap.put(61, "陕西");
        areaMap.put(62, "甘肃");
        areaMap.put(63, "青海");
        areaMap.put(64, "宁夏");
        areaMap.put(65, "新疆");
        areaMap.put(71, "台湾");
        areaMap.put(81, "香港");
        areaMap.put(82, "澳门");
        areaMap.put(91, "国外");
 
        return areaMap.get(idcard);
    }
 
 
}