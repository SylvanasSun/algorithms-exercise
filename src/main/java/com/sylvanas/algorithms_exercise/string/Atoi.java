package com.sylvanas.algorithms_exercise.string;

/**
 * 转换字符串到整数
 * 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。
 *
 * Created by SylvanasSun on 10/27/2017.
 */
public class Atoi {

    public static int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        // 判断是正数还是负数
        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '+')
            i++;
        else if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }

        double result = 0.0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            // *10是为了进位, -'0'是因为在ASCII码中,任何数字字符减去0才能得到真正的整数
            // 例如1的ASCII码值为49,0位48, '1' - '0' = 1, '2' - '0' = 2...
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }

        if (flag == '-')
            result = -1 * result;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;
    }

}
