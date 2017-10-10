package com.sylvanas.algorithms_exercise.array;

/**
 * 最大子数组
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 挑战: 要求时间复杂度为O(n)
 *
 * Created by SylvanasSun on 10/10/2017.
 */
public class MaxSubArray {

    /**
     * 使用贪心法,丢弃掉所有和为负数的子数组排列
     */
    public static int solution(int[] nums) {
        if (nums.length == 0)
            return -1;

        int length = nums.length;
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum > maximum)
                maximum = sum;
            if (sum < 0)
                sum = 0; // 丢弃和为负数的排列
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        assert solution(nums) == 6;
    }

}
