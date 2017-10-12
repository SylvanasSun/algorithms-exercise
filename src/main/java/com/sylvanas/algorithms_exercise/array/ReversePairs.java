package com.sylvanas.algorithms_exercise.array;

/**
 * 逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 给你一个数组，求出这个数组中逆序对的总数。
 * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
 *
 * Created by SylvanasSun on 10/12/2017.
 */
public class ReversePairs {

    /**
     * 暴力法,直接穷举所有组合
     */
    public static long solution1(int[] arr) {
        if (arr.length == 0)
            return 0;

        int length = arr.length;
        long counter = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j])
                    counter++;
            }
        }

        return counter;
    }

    /**
     * 使用归并排序,归并排序中含有i指针(在中间值之前)与j指针(再中间值之后),
     * 只要i指针的值大于j指针的值(i指针的位置是一定比j指针小的),
     * 那么就可以计算逆序对的数量(mid - i + 1,因为是有序的,所以逆序对数要加上i,j之间相差的距离)
     */
    public static long solution2(int[] arr) {
        if (arr.length == 0)
            return 0;

        long[] result = new long[1];
        result[0] = 0;
        mergeSort(arr, 0, arr.length - 1, result);
        return result[0];
    }

    private static void mergeSort(int[] arr, int low, int high, long[] result) {
        if (low >= high)
            return;

        int mid = (low + high) >> 1;
        mergeSort(arr, low, mid, result);
        mergeSort(arr, mid + 1, high, result);
        merge(arr, low, mid, high, result);
    }

    private static void merge(int[] arr, int low, int mid, int high, long[] result) {
        int[] temp = new int[arr.length];
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++)
            temp[k] = arr[k];

        for (int k = low; k <= high; k++) {
            if (i > mid)
                arr[k] = temp[j++];
            else if (j > high)
                arr[k] = temp[i++];
            else if (temp[i] <= temp[j])
                arr[k] = temp[i++];
            else {
                // arr[i] > arr[j] 计算逆序对
                arr[k] = temp[j++];
                result[0] += mid - i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        long result = solution2(arr);
        assert result == 3;
        int[] arr2 = {2, 4, 1, 3, 5};
        long result2 = solution1(arr2);
        assert result2 == 3;
    }

}
