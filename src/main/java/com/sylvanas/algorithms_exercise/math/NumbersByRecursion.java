package com.sylvanas.algorithms_exercise.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 用递归的方法找到从1到最大的N位整数。
 * 用下面这种方式去递归其实很容易：
 * recursion(i) {
 * if i > largest number:
 * return
 * results.add(i)
 * recursion(i + 1)
 * }
 * 但是这种方式会耗费很多的递归空间，导致堆栈溢出。你能够用其他的方式来递归使得递归的深度最多只有 N 层么？
 *
 * Example:
 * 给出 N = 1, 返回[1,2,3,4,5,6,7,8,9].
 * 给出 N = 2, 返回[1,2,3,4,5,6,7,8,9,10,11,...,99].
 *
 * Created by SylvanasSun on 10/1/2017.
 */
public class NumbersByRecursion {

    public static List<Integer> solution(int n) {
        if (n <= 0)
            return new ArrayList<>();
        else if (n == 1) {
            // 只有1位,直接返回1......9
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= 9; i++)
                result.add(i);
            return result;
        } else {
            // 获得n-1位的集合
            List<Integer> list = solution(n - 1);
            List<Integer> result = new ArrayList<>(list);
            for (int i = 1; i <= 9; i++) {
                // 获得最高位
                int topDigit = (int) (Math.pow(10, n - 1) * i);
                result.add(topDigit);
                // 最高位加上上一位的每一个数字
                for (Integer aList : list)
                    result.add(topDigit + aList);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        final int n = 2;
        int[] arr = new int[99];
        for (int i = 1; i <= 99; i++)
            arr[i - 1] = i;
        List<Integer> list = solution(n);
        int counter = 0;
        for (Integer aList : list) {
            assert aList == arr[counter++];
        }
    }

}
