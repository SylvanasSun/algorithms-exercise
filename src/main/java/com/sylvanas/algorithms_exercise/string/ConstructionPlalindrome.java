package com.sylvanas.algorithms_exercise.string;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 *
 * Created by SylvanasSun on 9/1/2017.
 */
public class ConstructionPlalindrome {

    public static int construction_plalindrome(String str) {
        if (str == null || "".equals(str))
            throw new IllegalArgumentException("String is empty or null!");

        String reverse_str = new StringBuilder(str).reverse().toString();
        return get_minimum_deleted_char_length(str, reverse_str);
    }

    // 找出字符串与其反串的最大公共字符的个数,然后用原字符串的长度减去这个最大公共字符个数
    // 就能得到最小删除数
    private static int get_minimum_deleted_char_length(String s1, String s2) {
        int length = s1.length();
        int[][] max_len = new int[length + 1][length + 1]; // 最长公共字符序列

        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                // 比较s1[i - 1]与s2[j - 1]
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 匹配成功,进行记录并与上对角(max_len[i-1][j-1])累计在一起
                    max_len[i][j] = max_len[i - 1][j - 1] + 1;
                } else {
                    // 匹配失败,取其坐标左边(max_len[i-1][j])与上面(max_len[i][j-1])的最大值
                    max_len[i][j] = Math.max(max_len[i - 1][j], max_len[i][j - 1]);
                }
            }
        }
        // 经过上面的循环运算,已经将累计的最大次数推至了最右下(max_len[length][length])
        return length - max_len[length][length];
    }

    public static void main(String[] args) {
        int google = construction_plalindrome("google");
        int abcda = construction_plalindrome("abcda");
        assert google == 2;
        assert abcda == 2;
    }

}
