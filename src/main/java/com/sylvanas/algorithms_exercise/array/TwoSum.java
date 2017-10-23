package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
 * Example: 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 *
 * Created by SylvanasSun on 10/23/2017.
 */
public class TwoSum {

    /**
     * 暴力解法
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0)
            return new int[0];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // 注意返回的下标范围是1到n,不是以0开头
                    list.add(i + 1);
                    list.add(j + 1);
                }
            }
        }

        int[] result = new int[list.size()];
        int cnt = 0;
        for (Integer i : list) {
            result[cnt++] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] sum = TwoSum.twoSum(numbers, 9);
        assert sum[0] == 1;
        assert sum[1] == 2;
    }

}
