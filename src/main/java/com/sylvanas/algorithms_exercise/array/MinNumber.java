package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 将数组重新排序以构造最小值
 * 给定一个整数数组，请将其重新排序，以构造最小值。
 * 挑战: 在原数组上完成，不使用额外空间。
 * Example:
 * 给定 [3, 32, 321]，通过将数组重新排序，可构造 6 个可能性数字：
 * 3+32+321=332321
 * 3+321+32=332132
 * 32+3+321=323321
 * 32+321+3=323213
 * 321+3+32=321332
 * 321+32+3=321323
 * 其中，最小值为 321323，所以，将数组重新排序后，该数组变为 [321, 32, 3]。
 *
 * Created by SylvanasSun on 10/16/2017.
 */
public class MinNumber {

    /**
     * 本题需要注意的是需要比较数组元素的每一位(如321和3)
     */
    public static String minNumber(int[] nums) {
        if (nums.length == 0)
            return "";

        // 将整数数组转换为字符串
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(String.valueOf(nums[i]));

        // 使用Collections.sort()进行排序,需要自定义一个比较器
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i = 0;
                char c1;
                char c2;
                for (; i < s1.length() && i < s2.length(); i++) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                    if (c1 < c2)
                        return -1;
                    else if (c1 > c2)
                        return 1;

                }
                // 如果有相等的元素,则要考虑两个字符串哪一个已经到结尾了
                if (i == s1.length() && i == s2.length())
                    return 0;

                // 否则需要继续与剩下的字符比较
                if (i < s2.length())
                    return compare(s1, s2.substring(i));
                else
                    return compare(s1.substring(i), s2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list)
            stringBuilder.append(s);
        String result = stringBuilder.toString();

        // 考虑输入为[0,0,0,1,2,3]的情况,正确的输出应该为123
        // 所以需要去除0
        int i = 0;
        while (result.charAt(i) == '0' && i < result.length() - 1)
            i++;

        return result.substring(i);
    }

}
