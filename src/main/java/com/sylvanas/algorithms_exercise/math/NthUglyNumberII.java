package com.sylvanas.algorithms_exercise.math;

/**
 * 丑数 II
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * (我们可以认为1也是一个丑数)
 * 挑战: 要求时间复杂度为O(nlogn)或者O(n)
 * Example: 如果n = 9， 返回 10
 *
 * Created by SylvanasSun on 10/21/2017.
 */
public class NthUglyNumberII {

    /**
     * 初始化2,3,5的三个种子,并定义一个数组用来存放丑数.
     * 之后不断从三个种子中挑选:
     * 1. 选择num[0]*2，num[0]*3，num[0]*5中最小的数为新的丑数 (选2,然后该种子自增)
     * 2. 选择num[1]*2，num[0]*3，num[0]*5中进行选择(选3,然后该种子自增)
     * ....
     */
    public static int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;

        int[] ugly = new int[n];
        int num_2 = 0, num_3 = 0, num_5 = 0;
        ugly[0] = 1; // 最小的丑数

        for (int i = 1; i < n; i++) {
            int number = Math.min(Math.min(ugly[num_2] * 2, ugly[num_3] * 3), ugly[num_5] * 5);
            // 注意,可能会有多个种子用到 所以一定要使用多个if
            if (number / ugly[num_2] == 2)
                num_2++;
            if (number / ugly[num_3] == 3)
                num_3++;
            if (number / ugly[num_5] == 5)
                num_5++;
            ugly[i] = number;
        }

        return ugly[n - 1];
    }

}
