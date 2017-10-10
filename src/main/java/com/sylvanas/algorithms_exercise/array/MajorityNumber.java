package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 主元素
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 挑战:要求时间复杂度为O(n)，空间复杂度为O(1)
 *
 * Created by SylvanasSun on 10/10/2017.
 */
public class MajorityNumber {

    /**
     * 主要思路将数据分成两堆: 主元素与其他数
     * 每次循环前先判断候选数计数器是否为0,如果为0,则重设候选数.
     * 如果不为0,还需要判断当前数是否为候选数,如果不同,计数器减一(相当于从主元素堆中取走一个)
     * 如果相同,计数器加一(相当于主元素堆增加)
     */
    public static int solution(List<Integer> nums) {
        if (nums == null || nums.size() == 0)
            return -1;

        int counter = 0;
        int candidate = 0;

        for (Integer i : nums) {
            if (counter == 0) {
                candidate = i;
                counter++;
            } else {
                if (candidate == i)
                    counter++;
                else
                    counter--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            list.add(1);
        for (int i = 0; i < 10; i++)
            list.add(2);
        list.add(6);
        list.add(7);
        for (int i = 0; i < 6; i++)
            list.add(10);
        int result = solution(list);
        assert result == 2;
    }

}
