package com.sylvanas.algorithms_exercise.math;

/**
 * 快速幂  计算a^n % b，其中a，b和n都是32位的整数。
 *
 * 挑战: O(log n)
 *
 * Example:
 * 2^31 % 3 = 2
 * 100^1000 % 1000 = 0
 *
 * Created by SylvanasSun on 10/3/2017.
 */
public class FastPower {

    /**
     * 为了提高效率,使用二分法,每次对n/2(减少了一半计算量).
     */
    public static int solution(int a, int b, int n) {
        if (n == 0)
            return 1 % b; // 0次方永远为1
        else if (n == 1)
            return a % b; // 1次方为本身

        // 使用long,为了防止整数溢出
        long remainder = (long) solution(a, b, n >> 1);
        // a ^ n = (a ^ n / 2) * (a ^ n / 2)
        remainder = remainder * remainder % b;

        // 如果是奇数,还需要再补上舍去的1次幂
        if (n % 2 == 1)
            remainder = remainder * (a % b) % b;

        return (int) remainder;
    }

    public static void main(String[] args) {
        int result_1 = solution(2, 3, 31);
        int result_2 = solution(100, 1000, 1000);
        assert result_1 == 2;
        assert result_2 == 0;
    }

}
