package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTests {

    @Test
    void solutionTest() {
        int[] nums = {2, 7, 11, 15};
        int[] expected = {1, 2};
        int target = 9;
        int[] actual = TwoSum.twoSum(nums, target);
        assertArrayEquals(expected, actual);
    }

}
