package com.geekmake.groovy.rules.utils;

/**
 * @author pez1420@gmail.com
 * @version $Id: StringUtils.java v 0.1 2020/7/29 9:25 下午 pez1420 Exp $$
 */
public final class StringUtils {

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串的数字前面增加前缀
     *
     * @param str   String
     *              原字符串
     * @param prefix String
     *               数字前面需要增加的前缀
     * @return String
     */
    public static String addPrefixBeforeNumber(String str, String prefix) {
        StringBuilder result = new StringBuilder();
        boolean isChar = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(str.charAt(i));
                if (i == str.length() - 1) {
                    sb.setLength(0);
                }
                isChar = false;
            } else {
                if (sb.length() > 0 && isChar == false) {
                    result.append(prefix).append(sb.toString());
                    sb.setLength(0);
                }
                result.append(c);
                isChar = true;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String t = addPrefixBeforeNumber("(1 && (2 || 3) || !4)", "t");
        System.out.println(t);
    }
}
