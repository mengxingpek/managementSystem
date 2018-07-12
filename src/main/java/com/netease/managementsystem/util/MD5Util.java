package com.netease.managementsystem.util;


import java.security.MessageDigest;

/**
 * @Author mengxing
 * @Date 2018/7/11 下午2:42
 */


public class MD5Util {

    private static final String ENCODE = "afbet";
    // 随机密码的assic码做salt
    private static final byte[] SALT = {0x42, 0x49, 0x70, 0x55, 0x78, 0x4D, 0x4E, 0x6F, 0x6F, 0x54, 0x78, 0x52};

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};

    public final static String md5(String s) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(SALT);
            // 使用指定的字节更新摘要
            mdInst.update(s.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static String md5WithoutSalt(String s) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(s.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // password明文用此加密
    public final static String password(String s) {
        return md5(md5(s)+ENCODE);
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.password("1"));
    }
}
