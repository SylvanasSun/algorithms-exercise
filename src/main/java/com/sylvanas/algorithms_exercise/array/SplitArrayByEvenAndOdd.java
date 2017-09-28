package com.sylvanas.algorithms_exercise.array;

/**
 * 分割一个整数数组，使得奇数在前偶数在后。
 * Example: 给定 [1, 2, 3, 4]，返回 [1, 3, 2, 4]。
 * 挑战: 在原数组中完成，不使用额外空间。
 *
 * Created by SylvanasSun on 9/28/2017.
 */
public class SplitArrayByEvenAndOdd {

    /**
     * 通过头尾指针判断是否为偶数,如果为偶数就交换到尾指针
     */
    public static void solution(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int tail = arr.length - 1;
        int head = 0;

        while (head < tail) {
            if (arr[head] % 2 == 0) {
                int temp = arr[tail];
                arr[tail] = arr[head];
                arr[head] = temp;
                tail--;
            } else {
                head++;
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
