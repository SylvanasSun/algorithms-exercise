package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组剔除元素后的乘积
 * 给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
 *
 * Created by SylvanasSun on 10/27/2017.
 */
public class ProductExcludeItself {

    public static List<Long> productExcludeItself(List<Integer> nums) {
        List<Long> result = new ArrayList<>();
        if (nums == null || nums.size() == 1) {
            result.add((long) 1);
            return result;
        }

        int size = nums.size();
        long[] left = new long[size];
        long[] right = new long[size];
        left[0] = 1;
        right[size - 1] = 1;

        // left[i]用来表示A[i]左边元素的乘积,不包括A[i]
        for (int i = 1; i < size; i++)
            left[i] = left[i - 1] * nums.get(i - 1);

        // right[i]用来表示A[i]右边元素的乘积,不包括A[i]
        for (int i = size - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums.get(i + 1);

        // 最终结果为B[i] = left[i] * right[i]
        for (int i = 0; i < size; i++)
            result.add(left[i] * right[i]);

        return result;
    }

}
