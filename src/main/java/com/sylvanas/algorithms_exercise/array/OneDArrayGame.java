package com.sylvanas.algorithms_exercise.array;

/**
 * Let's play a game on an array! You're standing at index 0 of an
 * n-element array named game. From some index i(where 0 <= i < n),
 * you can perform one of the following moves:
 *
 * 1. Move Backward: if cell i - 1 exists and contains a 0, you can walk back to cell i - 1.
 * 2. Move Forward:
 * - if cell i + 1 contains a zero, you can walk to cell i + 1.
 * - if cell i + leap contains a zero, you can jump to cell i + leap.
 * - if you're standing in cell n - 1 or the value of i + leap >= n,
 * you can walk or jump off the end of the array and win the game.
 *
 * In other words, you can move from index i to index i + 1, i - 1 or i + leap
 * as long as the destination index is a cell containing a 0, if the destination
 * index is greater than n - 1, you win the game.
 * Give leap and game, complete the function in the editor below so that
 * it returns true if you can win the game or false if you cannot.
 *
 * This problem from: https://www.hackerrank.com/challenges/java-1d-array/problem
 *
 * Created by SylvanasSun on 1/16/2018.
 */
public class OneDArrayGame {

    /**
     * Solution is basically to do a depth-first-search,
     * Instead of creating a "visited" array, we can mark each array
     * element as 1 when visiting it.
     */
    public static boolean canWin(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1)
            return false;
        else if (i + 1 >= game.length || i + leap >= game.length)
            return true;

        game[i] = 1;
        return canWin(leap, game, i + leap) ||
                canWin(leap, game, i + 1) ||
                canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        int leap = 3;
        int[] game = new int[n];
        for (int i = 0; i < n; i++)
            game[i] = 0;
        assert canWin(leap, game, 0);

        leap = 5;
        game = new int[]{0, 0, 0, 1, 1, 1};
        assert canWin(leap, game, 0);

        leap = 3;
        game = new int[]{0, 0, 1, 1, 1, 0};
        assert !canWin(leap, game, 0);

        leap = 1;
        game = new int[]{0, 1, 0};
        assert !canWin(leap, game, 0);
    }

}
