package com.sylvanas.algorithms_exercise.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of numbers, return all possible permutations.
 * For Example:
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * Created by SylvanasSun on 2/23/2018.
 */
public class Permutations {

    /**
     * Loop through the array, in each iteration, a new number is added to different
     * locations of results of previous iteration. Start from an empty List.
     *
     * steps:
     * [1]
     * [2, 1]
     * [1, 2]
     * [3, 2, 1]
     * [2, 3, 1]
     * [2, 1, 3]
     * [3, 1, 2]
     * [1, 3, 2]
     * [1, 2, 3]
     */
    public static List<List<Integer>> solutionA(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        // start from an empty list
        result.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            // list of list in current iteration of the array num
            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> list : result) {
                // of locations to insert is largest index + 1
                for (int j = 0; j < list.size() + 1; j++) {
                    // add arr[i] to different locations
                    list.add(j, arr[i]);
                    List<Integer> temp = new ArrayList<>(list);
                    current.add(temp);
                    list.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }

    /**
     * We can also recursively solve this problem. Swap each element with each element after it.
     */
    public static List<List<Integer>> solutionB(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    private static void permute(int[] arr, int start, List<List<Integer>> result) {
        if (start >= arr.length) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            result.add(list);
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1, result);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        List<List<Integer>> resultA = solutionA(a);
        List<List<Integer>> resultB = solutionB(b);
        resultA.forEach(System.out::println);
        System.out.println("---------------------------");
        resultB.forEach(System.out::println);
    }

}
