package com.sylvanas.algorithms_exercise.math;

/**
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 *
 * Created by SylvanasSun on 9/14/2017.
 */
public class SearchTwoDimensionMatrix2 {

    /**
     * 具体思路:
     * 从左下角不断比较直到右上角(也可以从右上角到左下角)
     */
    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return 0;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int result = 0;
        // 从左下角开始 matrix[length - 1][0]
        int x = row;
        int y = 0;

        while (x >= 0 && y < col) {
            int pivot = matrix[x][y];
            if (pivot == target) {
                result++;
                x--; // 移动到上一行
            } else if (pivot < target) {
                y++; // 移到下一列
            } else {
                x--; //当前列没有找到,移到上一行
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int[] col_arr_01 = {1, 3, 5, 7};
        int[] col_arr_02 = {2, 4, 7, 8};
        int[] col_arr_03 = {3, 5, 9, 10};
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

        assert searchMatrix(matrix, 3) == 2;
    }

}
