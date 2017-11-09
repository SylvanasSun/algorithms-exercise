package com.sylvanas.algorithms_exercise.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数据流中位数
 * 数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。
 * 中位数的定义：
 * 中位数是排序后数组的中间值，如果有数组中有n个数，则中位数为A[(n-1)/2]。
 * 比如：数组A=[1,2,3]的中位数是2，数组A=[1,19]的中位数是1。
 * Example:
 * 持续进入数组的数的列表为：[1, 2, 3, 4, 5]，则返回[1, 1, 2, 2, 3]
 * 持续进入数组的数的列表为：[4, 5, 1, 3, 2, 6, 0]，则返回 [4, 4, 4, 3, 3, 3, 3]
 * 持续进入数组的数的列表为：[2, 20, 100]，则返回[2, 2, 20]
 *
 * Created by SylvanasSun on 11/9/2017.
 */
public class MedianII {

    public static int[] medianII(int[] nums) {
        /**
         * 左边为一个最大堆,右边为一个最小堆
         * 最大堆用于保存数组中较小的一半数,最小堆保存的是较大的另一半数.
         * 当元素为数组的奇数个数时,插入到最大堆中,否则,插入到最小堆中.
         * 最终,最大堆的堆顶即为中位数.
         */
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (flag) {
                /**
                 * 如果新数大于右边最小堆的堆顶,那么证明新数是在右边的
                 * 那么就先将新数插入右边最小堆,并把最小堆的新堆顶赋值给temp并移除.
                 */
                if (!right.isEmpty() && temp > right.peek()) {
                    right.add(temp);
                    temp = right.poll();
                }
                left.add(temp);
            } else {
                // 逻辑与上述相反
                if (!left.isEmpty() && temp < left.peek()) {
                    left.add(temp);
                    temp = left.poll();
                }
                right.add(temp);
            }
            flag = !flag;
            list.add(left.peek());
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}
