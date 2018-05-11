package com.sylvanas.algorithms_exercise.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We define a magic square to be an n x n matrix of distinct positive integers from 1 to n^2 where the sum
 * of any row, column, or diagonal of length n is always equal to the same number: the magic constant.
 *
 * You will be given a 3 x 3 matrix s of integers in the inclusive range [1, 9]. We can convert any digit
 * a to any other digit b in the range [1, 9] at cost of |a - b|. Given s, convert it into a magic square
 * at minimal cost. Print this cost on a new line.
 *
 * For example, we start with the following matrix s:
 *
 * 5 3 4
 * 1 5 8
 * 6 4 2
 *
 * We can convert it to the following magic square:
 *
 * 8 3 4
 * 1 5 9
 * 6 7 2
 *
 * This took three replacements at a cost of |5 - 8| + |8 - 9| + |4 - 7| = 7.
 *
 * For more description: https://www.hackerrank.com/challenges/magic-square-forming/problem
 *
 * Created by SylvanasSun on 5/11/2018.
 */
public class FormingAMagicSquare {

    /**
     * We can start with two observations:
     * 1. the middle of any 3 x 3 magic square must be 5.
     * 2. the magic sum must be 15.
     *
     * For the magic sum, the sum of numbers [1-9] is 45, the three
     * horizontal rows will include all 9 numbers (and thus sum to 45).
     * And since there are three rows, each row will sum to 45 / 3 = 15.
     *
     * Once we know these two things, we can think in terms of the 4 pairs
     * that can go on opposite sides of the 5:
     *
     * 1 and 9
     * 2 and 8
     * 3 and 7
     * 4 and 6
     *
     * So for example, if 4 goes top or left, we know that 6 must go bottom or right,
     * since the magic sum must be 15, and 5 is in the middle.
     *
     * For the 4 pairs of above, only two fit in the corners:
     *
     * 2 and 8
     * 4 and 6
     *
     * The other two pairs must be wedged inside the corner pairs, and once we
     * set our four corners, these is only 1 way to place the rest of the numbers.
     *
     * This is enough to show that there are 8 magic matrices. There are 4 possible
     * ways to place the 4 and 6 pair (the 4 could go in top or left, top or right,
     * bottom or right, bottom or left).
     *
     * Then once we place the 4 and 6, there are two different ways we could place the 2 and 8.
     *
     * To actually generate these matrices, i started with one seed.
     *
     * 4 3 8
     * 9 5 1
     * 2 7 6
     *
     * From the seed, we can rotate it clockwise 4 times (so the 4 appears in each corner),
     * and then from each rotation, we can place the remaining digits either clockwise, or
     * counterclockwise around the 5(going counterclockwise is equivalent to getting the mirror
     * of the matrix x along a diagonal).
     */
    public static int solution(int[][] s) {
        int MAGIC_CONSTANT = 15;
        int middle = s[1][1];
        List<Integer> results = new ArrayList<>();

        /**
         * We need to figure valid combinations of 3 numbers that add to 15
         * There are 8 of the combinations, that is the mirror images (horizontally
         * and vertically) and the rotation of each.
         *
         * For example:
         *
         * Mirror images
         * -------------
         * 4 9 2 | 2 9 4
         * 3 5 7 | 7 5 3
         * 8 1 6 | 6 1 8
         * -------------
         * 8 1 6 | 6 1 8
         * 3 5 7 | 7 5 3
         * 4 9 2 | 2 9 4
         *
         * Corresponding rotations
         * --------------
         * 8 3 4 | 4 3 8
         * 1 5 9 | 9 5 1
         * 6 7 2 | 2 7 6
         * -------------
         * 6 7 2 | 2 7 6
         * 1 5 9 | 9 5 1
         * 8 3 4 | 4 3 8
         *
         */

        for (int i = 0; i < 2; i++) {
            // First compute for seed
            compute(s, MAGIC_CONSTANT, middle, results);

            // Convert to the mirror image and compute
            horizontallyMirror(s);
            compute(s, MAGIC_CONSTANT, middle, results);

            verticallyMirror(s);
            compute(s, MAGIC_CONSTANT, middle, results);

            horizontallyMirror(s);
            compute(s, MAGIC_CONSTANT, middle, results);

            verticallyMirror(s);
            // Rotate then repeat the above operation
            s = rotate(s);
        }

        Collections.sort(results);
        return results.get(0);
    }

    // clockwise rotate the magic square
    private static int[][] rotate(int[][] s) {
        int n = s.length;
        int m = s[0].length;
        int[][] r = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = s[n - j - 1][i];
            }
        }

        return r;
    }

    private static void horizontallyMirror(int[][] s) {
        int tmp;
        int m = s.length - 1;

        for (int i = 0; i <= m; i++) {
            tmp = s[i][0];
            s[i][0] = s[i][m];
            s[i][m] = tmp;
        }
    }

    private static void verticallyMirror(int[][] s) {
        int tmp;
        int m = s.length - 1;

        for (int i = 0; i <= m; i++) {
            tmp = s[0][i];
            s[0][i] = s[m][i];
            s[m][i] = tmp;
        }
    }

    private static void compute(int[][] s, int MAGIC_CONSTANT, int middle, List<Integer> results) {
        // pair 1
        int topLeft = s[0][0];
        int bottomRight = s[2][2];

        // pair 2
        int topMiddle = s[0][1];
        int bottomMiddle = s[2][1];

        // pair 3
        int topRight = s[0][2];
        int bottomLeft = s[2][0];

        // pair 4
        int middleRight = s[1][2];
        int middleLeft = s[1][0];

        int result = 0;
        result += Math.abs(MAGIC_CONSTANT - (topLeft + bottomRight + middle));
        result += Math.abs(MAGIC_CONSTANT - (topMiddle + bottomMiddle + middle));
        result += Math.abs(MAGIC_CONSTANT - (topRight + bottomLeft + middle));
        result += Math.abs(MAGIC_CONSTANT - (middleRight + middleLeft + middle));
        results.add(result);
    }

}
