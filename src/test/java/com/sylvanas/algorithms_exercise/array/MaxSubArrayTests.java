package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArrayTests {

    @Test
    @DisplayName("The maximum sum of the sub array should be 6.")
    void solutionTest() {
        int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        int actual = MaxSubArray.solution(nums);
        int expected = 6;
        assertEquals(expected, actual);
    }

}
