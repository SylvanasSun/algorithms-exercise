package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
 *
 * Created by SylvanasSun on 10/6/2017.
 */
public class SpiralMatrix {

    /**
     * 从最外圈开始不断缩小圈的范围并添加每一圈到List中.
     */
    public static List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // from left to right
            for (int i = startCol; i <= endCol; i++)
                result.add(matrix[startRow][i]);
            // from top to bottom
            for (int i = startRow + 1; i <= endRow; i++)
                result.add(matrix[i][endCol]);
            // from right to left
            if (startRow != endRow)
                for (int i = endCol - 1; i >= startCol; i--)
                    result.add(matrix[endRow][i]);
            // from bottom to top
            if (startCol != endCol)
                for (int i = endRow - 1; i > startRow; i--)
                    result.add(matrix[i][startCol]);

            // shrinking matrix
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                matrix[i][j] = counter++;
        }

        List<Integer> list = solution(matrix);
        assert list.size() == 9;
        assert list.get(0) == 1;
        assert list.get(1) == 2;
        assert list.get(2) == 3;
        assert list.get(3) == 6;
        assert list.get(4) == 9;
        assert list.get(5) == 8;
        assert list.get(6) == 7;
        assert list.get(7) == 4;
        assert list.get(8) == 5;
    }

}
