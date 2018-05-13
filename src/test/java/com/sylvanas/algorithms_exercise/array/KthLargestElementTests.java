package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestElementTests {

    @Test
    @DisplayName("The element which largest of the array should be 9 " +
            "and element which the third largest of the array should be 4.")
    void solutionTest() {
        int[] nums = {9, 3, 2, 4, 8};
        int actual = KthLargestElement.kthLargestElement(3, nums);
        int expected = 4;
        assertEquals(expected, actual);

        actual = KthLargestElement.kthLargestElement(1, nums);
        expected = 9;
        assertEquals(expected, actual);
    }

}
