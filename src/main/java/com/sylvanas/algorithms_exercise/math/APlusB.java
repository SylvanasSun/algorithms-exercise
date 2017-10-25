package com.sylvanas.algorithms_exercise.math;

/**
 * A + B 问题
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 *
 *
 * Created by SylvanasSun on 10/25/2017.
 */
public class APlusB {

    /**
     * 使用异或位运算模拟不含进位的算数操作(异或的特性 0^0 = 0,1^0 = 1,0^1 = 1,1^1 = 0)
     * 然后使用与位运算并左移1位模拟进位
     */
    public static int aPlusB(int a, int b) {
        int sum = 0;
        int carry = 0;

        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (carry != 0);

        return sum;
    }

}
