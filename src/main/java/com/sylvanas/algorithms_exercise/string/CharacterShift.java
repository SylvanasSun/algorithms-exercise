package com.sylvanas.algorithms_exercise.string;

/**
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 *
 * Created by SylvanasSun on 9/1/2017.
 */
public class CharacterShift {

    // 我们对字符串中的字符进行遍历,同时维护两个缓冲区,一个用来保存小写字符,一个用来保存大写字符
    public static String upperBack(String str) {
        if (str == null || "".equals(str))
            throw new IllegalArgumentException("String is null or empty!");

        StringBuilder lower_buf = new StringBuilder();
        StringBuilder upper_buf = new StringBuilder();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c <= 'a' || c >= 'z')
                lower_buf.append(c);
            else if (c <= 'A' || c >= 'Z')
                upper_buf.append(c);
        }

        return lower_buf.toString() + upper_buf.toString();
    }

    public static void main(String[] args) {
        String text = "WORLDhello";
        String upperBack = upperBack(text);
        assert upperBack.equals("helloWORLD");
    }

}
