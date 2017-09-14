package com.sylvanas.algorithms_exercise.math;

/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 *
 * Created by SylvanasSun on 9/14/2017.
 */
public class SearchTwoDimensionMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int x = 0;
        int y = col;
        // 从右上角一直到左下角
        while (x <= row && y >= 0) {
            int pivot = matrix[x][y];
            if (pivot == target)
                return true;
            else if (pivot < target)
                x++;
            else
                y--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int[] col_arr_01 = {1, 3, 5, 7};
        int[] col_arr_02 = {10, 11, 16, 20};
        int[] col_arr_03 = {23, 30, 34, 50};
        int[] temp = null;

        for (int i = 0; i < matrix.length; i++) {
            if (i == 0)
                temp = col_arr_01;
            else if (i == 1)
                temp = col_arr_02;
            else if (i == 2)
                temp = col_arr_03;

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = temp[j];
            }
        }

        assert searchMatrix(matrix, 3);
    }

}
