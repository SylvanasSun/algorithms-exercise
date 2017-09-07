package com.sylvanas.algorithms_exercise.math;

import java.util.*;

/**
 * 有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 *
 * Created by SylvanasSun on 9/1/2017.
 */
public class AcquireMinresAndMaxres {

    private static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

    /**
     * 获得最小差数对与最大差数对,返回的int[0]为最小差,int[1]为最大差
     */
    public static int[] getMinresAndMaxres(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array is null or empty!");
        }

        int n = numbers.length;
        int[] result = new int[2];
        // 先将数组进行排序
        Arrays.sort(numbers);

        // 先判断数组中是否所有数字都相同,如果全都相同直接用算法(差最大个数 = 差最小个数 = (n * (n - 1)) / 2 )返回结果即可.
        if (numbers[0] == numbers[n - 1]) {
            int pairs = arrayIsSame(numbers);
            result[0] = pairs;
            result[1] = pairs;
            return result;
        }

        // 使用map对数组中的数字进行统计
        for (int i = 0; i < n; i++) {
            int number = numbers[i];
            if (map.containsKey(number))
                map.put(number, map.get(number) + 1);
            else
                map.put(number, 1);
        }

        result[0] = getMinres(numbers);
        result[1] = getMaxres(numbers);

        return result;
    }

    /**
     * 获得最小差数对:
     * 计算差最小个数:
     * 如果数组中没有重复的数字,说明最小差不为0,最小差一定为数组中两个相邻数字的差,那么遍历数组,计算并统计.
     * 如果数组中有重复数字(map的size与数组大小不符),说明最小差为0,此时遍历map,
     * 将数字不为0的数(不为0的数的差必将产生最小差0)利用公式计算统计.
     */
    private static int getMinres(int[] a) {
        int minres = 0;
        int length = a.length;

        if (map.size() == length) {
            int min = Math.abs(a[1] - a[0]);
            for (int i = 2; i < length; i++) {
                int temp = Math.abs(a[i] - a[i - 1]);
                if (temp == min)
                    minres++;
                else if (temp < min) {
                    min = temp;
                    minres = 1;
                }
            }
        } else {
            for (Integer key : map.keySet()) {
                Integer val = map.get(key);
                if (val > 1)
                    minres += (val * (val - 1)) / 2;
            }
        }

        return minres;
    }

    /**
     * 获得差最大的数对: 只有一种情况,将最小值与最大值两两组合(最小值个数 * 最大值个数).
     */
    private static int getMaxres(int[] a) {
        int maxres = 0;
        List<Integer> keySet = new ArrayList<Integer>(map.keySet());
        Integer min_val = map.get(keySet.get(0));
        Integer max_val = map.get(keySet.get(keySet.size() - 1));
        maxres = min_val * max_val;
        return maxres;
    }

    private static int arrayIsSame(int[] a) {
        int n = a.length;
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        int[] test = {45, 12, 45, 32, 5, 6};
        int[] minresAndMaxres = getMinresAndMaxres(test);
        assert minresAndMaxres[0] == 1;
        assert minresAndMaxres[1] == 2;
    }

}
