package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SplitArrayByEvenAndOddTests {

    @Test
    @DisplayName("The separated array by even and odd should be {1,3,2,4}.")
    void solutionTest() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {1, 3, 2, 4};
        SplitArrayByEvenAndOdd.solution(nums);
        assertArrayEquals(expected, nums);
    }

}
