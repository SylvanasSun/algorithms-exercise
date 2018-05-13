package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchRangeTests {

    @Test
    @DisplayName("The range of the element 8 of the array {5,7,7,8,8,10} should be {3,4}.")
    void solutionTest() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] expected = {3, 4};
        int target = 8;
        int[] actual = SearchRange.searchRange(nums, target);
        assertArrayEquals(expected, actual);
    }

}
