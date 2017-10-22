package com.sylvanas.algorithms_exercise.math;

/**
 * 落单的数
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * 挑战: 一次遍历，常数级的额外空间复杂度
 * Example: 给出 [1,2,2,1,3,4,3]，返回 4
 *
 * Created by SylvanasSun on 10/22/2017.
 */
public class SingleNumber {

    /**
     * 使用异或,两个相同数进行异或操作会返回0,所以单数会被保留下来
     */
    public static int singleNumber(int[] A) {
        if (A.length == 0)
            return 0;

        int n = 0;
        for (int i = 0; i < A.length; i++)
            n = n ^ A[i];

        return n;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1, 3, 4, 3};
        int result = SingleNumber.singleNumber(A);
        assert result == 4;
    }

}
