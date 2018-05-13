package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinNumberTests {

    @Test
    @DisplayName("The minimum number should be 321323.")
    void solutionTest() {
        int[] nums = {3, 32, 321};
        String actual = MinNumber.minNumber(nums);
        String expected = "321323";
        assertEquals(expected, actual);
    }

}
