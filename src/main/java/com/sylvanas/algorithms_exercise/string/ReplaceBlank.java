package com.sylvanas.algorithms_exercise.string;

import java.util.Arrays;

/**
 * 将一个字符串中的所有空格替换成 %20.你可以假设该字符串有足够的空间来加入新的字符,且你得到的是“真实的”字符长度.
 * 同时需要返回新的字符串长度.
 *
 * Created by SylvanasSun on 9/5/2017.
 */
public class ReplaceBlank {

    public static int replaceBlank_01(char[] string, int length) {
        int new_length = length;

        // record new length
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ')
                new_length += 2; // %20 = 3 char
        }

        // append %20
        int index = new_length;
        for (int i = length - 1; i >= 0; i--) {
            char c = string[i];
            if (c == ' ') {
                string[--index] = '0';
                string[--index] = '2';
                string[--index] = '%';
            } else {
                string[--index] = c;
            }
        }

        return new_length;
    }

    public static int replaceBlank_02(char[] string, int length) {
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                // right shift
                for (int j = length + 2; j > i + 2; j--) {
                    string[j] = string[j - 2];
                }
                // append %20
                string[i] = '%';
                string[i + 1] = '2';
                string[i + 2] = '0';
                // record new length
                length += 2;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String text = "Mr John Smith";
        int length = text.length();
        char[] chars = text.toCharArray();
        int new_length_01 = replaceBlank_01(Arrays.copyOf(chars, length + 100),length);
        int new_length_02 = replaceBlank_02(Arrays.copyOf(chars, length + 100),length);
        assert new_length_01 == 17;
        assert new_length_02 == 17;
    }

}
