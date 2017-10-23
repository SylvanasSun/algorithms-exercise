package com.sylvanas.algorithms_exercise.string;

/**
 * 翻转字符串
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 *
 * Created by SylvanasSun on 10/23/2017.
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        // 第一次遍历,将每个单词翻转并去掉多余的连续空格
        for (int i = 0; i < sb.length(); ) {
            char c = sb.charAt(i);
            if (i + 1 < sb.length() && c == ' ' && c == sb.charAt(i + 1)) {
                // 连续空格,删除多余的空格
                sb.deleteCharAt(i + 1);
                i++;
            } else if (c != ' ') {
                int j = i;
                while (j + 1 < sb.length() && sb.charAt(j + 1) != ' ')
                    j++; // 找到单词的最后一个字母
                //翻转单词
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    char k_char = sb.charAt(k + i);
                    sb.setCharAt(k + i, sb.charAt(j - k));
                    sb.setCharAt(j - k, k_char);
                }
                i = j + 1;
            } else {
                // 一个空格直接跳过
                i++;
            }
        }

        // 第二次遍历,将整个字符串翻转
        for (int i = 0; i < sb.length() / 2; i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
            sb.setCharAt(sb.length() - 1 - i, c);
        }

        return sb.toString();
    }

}
