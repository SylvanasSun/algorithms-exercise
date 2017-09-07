package com.sylvanas.algorithms_exercise.math;

/**
 * 统计一个32位整数的二进制有多少个1
 *
 * Created by SylvanasSun on 9/7/2017.
 */
public class CountBinaryOne {

    public static int countBinaryOne(int number) {
        if (number == 0)
            return 0;

        int count = 0;
        // 如果是负数,需要先处理符号位
        if (number < 0) {
            count++;
            // 0x80000000 转换为二进制 : 最高位为1 其他为0
            // 这个操作会将符号位的1变为0
            number = number ^ 0x80000000;
        }

        // 不断与最高位做&操作,判断是否为1,然后右移消除已经统计过的1
        while (number > 0) {
            if ((number & 1) == 1)
                count++;
            number >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int count_01 = countBinaryOne(32);
        int count_02 = countBinaryOne(5);
        int count_03 = countBinaryOne(1023);
        assert count_01 == 1;
        assert count_02 == 2;
        assert count_03 == 9;
    }

}
