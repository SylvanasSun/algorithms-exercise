package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ProductExcludeItselfTests {

    @Test
    @DisplayName("The excluded product of the sequence {1,2,3} should be {6,3,2}.")
    void solutionTest() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        List<Long> actual = ProductExcludeItself.productExcludeItself(nums);
        List<Long> expected = new ArrayList<>();
        expected.add(6L);
        expected.add(3L);
        expected.add(2L);

        assertIterableEquals(expected, actual);
    }

}
