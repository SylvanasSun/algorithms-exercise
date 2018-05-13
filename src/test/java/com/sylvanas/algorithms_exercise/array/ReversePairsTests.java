package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversePairsTests {

    private int[] nums;
    private long expected = 3;
    private final String display = "The total number of reverse pairs should be 3.";

    @BeforeEach
    void init() {
        nums = new int[]{2, 4, 1, 3, 5};
    }

    @Test
    @DisplayName(value = display)
    void solutionATest() {
        long actual = ReversePairs.solution1(nums);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = display)
    void solutionBTest() {
        long actual = ReversePairs.solution2(nums);
        assertEquals(expected, actual);
    }

}
