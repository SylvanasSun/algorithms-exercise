package com.sylvanas.algorithms_exercise.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityNumberTests {

    @Test
    @DisplayName("The major number of the list should be 1.")
    void solutionTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(2);

        int actual = MajorityNumber.solution(list);
        int expected = 1;
        assertEquals(expected, actual);
    }

}
