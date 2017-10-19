package com.sylvanas.algorithms_exercise.math;

/**
 * 统计数字
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * Example: 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 *
 * Created by SylvanasSun on 10/19/2017.
 */
public class DigitCounts {

    /**
     * 暴力解法,穷举每一位,如果相等就让计数器自增
     */
    public static int digitCounts(int k, int n) {
        if (k < 0 || n < 0)
            return -1;

        int counter = 0;

        for (int i = 0; i <= n; i++) {
            int number = i;

            while (number / 10 > 0) {
                if (number % 10 == k)
                    counter++;
                number = number / 10;
            }

            if (number == k)
                counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        assert DigitCounts.digitCounts(1, 12) == 5;
    }

}
