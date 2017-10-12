package com.sylvanas.algorithms_exercise.array;

/**
 * 螺旋矩阵 II
 * 给你一个数n生成一个包含1-n^2的螺旋形矩阵
 * Example:
 * n = 3
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * Created by SylvanasSun on 10/12/2017.
 */
public class SpiralMatrixII {

    /**
     * 按照一圈一圈的顺序添加元素,如果当n为奇数时,注意中心点.
     */
    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        if (n == 0)
            return result;

        int startRow = 0, startCol = 0;
        int endRow = n - 1, endCol = n - 1;
        int numCounter = 1;

        // 这里不是小于等于(大于等于)是因为要预留中心位置
        while (startRow < endRow && startCol < endCol) {
            // from left to right
            for (int i = startCol; i <= endCol; i++)
                result[startRow][i] = numCounter++;
            // from top to bottom
            for (int i = startRow + 1; i <= endRow; i++)
                result[i][endCol] = numCounter++;
            // from right to left
            for (int i = endCol - 1; i >= startCol; i--)
                result[endRow][i] = numCounter++;
            // from bottom to top
            for (int i = endRow - 1; i > startRow; i--)
                result[i][startCol] = numCounter++;

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        // 添加中心点
        if (n % 2 == 1)
            result[n >> 1][n >> 1] = numCounter;

        return result;
    }

}
