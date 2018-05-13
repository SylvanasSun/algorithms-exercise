package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OneDArraryGameTests {

    @Test
    void solutionTest() {
        int n = 5;
        int leap = 3;
        int[] game = new int[n];
        for (int i = 0; i < n; i++)
            game[i] = 0;

        assertTrue(OneDArrayGame.canWin(leap, game, 0));

        leap = 5;
        game = new int[]{0, 0, 0, 1, 1, 1};
        assertTrue(OneDArrayGame.canWin(leap, game, 0));

        leap = 3;
        game = new int[]{0, 0, 1, 1, 1, 0};
        assertFalse(OneDArrayGame.canWin(leap, game, 0));

        leap = 1;
        game = new int[]{0, 1, 0};
        assertFalse(OneDArrayGame.canWin(leap, game, 0));
    }

}
