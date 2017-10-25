package com.sylvanas.algorithms_exercise.string;

/**
 * 旋转字符串
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 挑战: 在数组上原地旋转，使用O(1)的额外空间
 * Example:
 * 对于字符串 "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 *
 * Created by SylvanasSun on 10/25/2017.
 */
public class RotateString {

    public static void rotateString(char[] str, int offset) {
        if (str.length <= 1 || offset == 0)
            return;

        int length = str.length;
        // 需要通过offset % length确定右移的轮数
        for (int i = 1; i <= offset % length; i++) {
            char temp = str[length - 1];
            int j = length - 2;
            while (j >= 0) {
                str[j + 1] = str[j];
                j--;
            }
            str[0] = temp;
        }
    }

}
