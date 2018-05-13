package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MedianIITests {

    @Test
    @DisplayName("The median sequence should be {4, 4, 4, 3, 3, 3, 3}.")
    void solutionTest() {
        int[] nums = {4, 5, 1, 3, 2, 6, 0};
        int[] actual = MedianII.medianII(nums);
        int[] expected = {4, 4, 4, 3, 3, 3, 3};
        assertArrayEquals(expected, actual);
    }

}
