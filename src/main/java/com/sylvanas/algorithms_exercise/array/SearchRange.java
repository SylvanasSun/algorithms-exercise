package com.sylvanas.algorithms_exercise.array;

/**
 * 搜索区间
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 * 挑战: 时间复杂度 O(log n)
 * Example:
 * 给出[5, 7, 7, 8, 8, 10]和目标值target=8,
 * 返回[3, 4]
 *
 * Created by SylvanasSun on 10/25/2017.
 */
public class SearchRange {

    public static int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int length = A.length;
        if (length == 0 || target < A[0] || target > A[length - 1])
            return result;

        // 分别找到左右边界
        result[0] = findLeftBorder(A, 0, length - 1, target);
        result[1] = findRightBorder(A, 0, length - 1, target);
        return result;
    }

    private static int findLeftBorder(int[] A, int left, int right, int target) {
        if (A[0] == target)
            return 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midInt = A[mid];
            if (midInt == target) {
                if (A[mid - 1] != target)
                    return mid;
                else
                    right = mid - 1;
            } else if (midInt < target) {
                left = mid + 1;
            } else if (midInt > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findRightBorder(int[] A, int left, int right, int target) {
        if (A[right] == target)
            return right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midInt = A[mid];
            if (midInt == target) {
                if (A[mid + 1] != target)
                    return mid;
                else
                    left = mid + 1;
            } else if (midInt < target) {
                left = mid + 1;
            } else if (midInt > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}
