package com.sylvanas.algorithms_exercise.array;

/**
 * 分割一个整数数组，使得奇数在前偶数在后。
 * Example: 给定 [1, 2, 3, 4]，返回 [1, 3, 2, 4]。
 * 挑战: 在原数组中完成，不使用额外空间。
 * <p>
 * Created by SylvanasSun on 9/28/2017.
 */
public class SplitArrayByEvenAndOdd {

    public static void solution(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int head = 0;
        int tail = arr.length - 1;
        int temp;

        while (head < tail) {
            while (arr[head] % 2 == 1)
                head++;
            while (arr[tail] % 2 == 0)
                tail--;

            if (head < tail) {
                temp = arr[head];
                arr[head] = arr[tail];
                arr[tail] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        solution(arr);
        assert arr[0] == 1;
        assert arr[1] == 3;
        assert arr[2] == 2;
        assert arr[3] == 4;
    }

}
