package com.sylvanas.algorithms_exercise.array;

/**
 * 第k大元素
 * 在数组中找到第k大的元素
 * Example:
 * 给出数组 [9,3,2,4,8]，第三大的元素是 4
 * 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
 * 挑战: 要求时间复杂度为O(n)，空间复杂度为O(1)
 *
 * Created by SylvanasSun on 10/19/2017.
 */
public class KthLargestElement {

    /**
     * 基于快速排序实现
     */
    public static int kthLargestElement(int k, int[] nums) {
        if (k <= 0 || nums.length == 0)
            return -1;

        return quickSort(nums, 0, nums.length - 1, k);
    }

    private static int quickSort(int[] nums, int left, int right, int k) {
        int i = left, j = right;
        int temp = nums[i];

        while (i < j) {
            while (i < j && temp >= nums[j])
                j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && temp < nums[i])
                i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }

        if (i == k - 1)
            return temp;
        else if (i < k - 1)
            return quickSort(nums, i + 1, right, k);
        else
            return quickSort(nums, left, i - 1, k);
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 2, 4, 8};
        int result = KthLargestElement.kthLargestElement(3, nums);
        assert result == 4;
    }

}
