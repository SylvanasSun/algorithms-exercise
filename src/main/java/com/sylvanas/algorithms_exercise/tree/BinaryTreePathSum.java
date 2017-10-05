package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的路径和: 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 *
 * Created by SylvanasSun on 10/4/2017.
 */
public class BinaryTreePathSum {

    public static List<List<Integer>> solution(TreeNode<Integer> root, int target) {
        if (root == null)
            return new ArrayList<>();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        binaryTreePathSum(root, result, queue, 0, target);
        return result;
    }

    /**
     * 前序遍历树,queue保存了路径上的每个值,sum保存了总值,当sum等于target并且当前节点没有子节点时,添加结果.
     */
    private static void binaryTreePathSum(TreeNode<Integer> root, List<List<Integer>> result,
                                          ArrayDeque<Integer> queue, int sum, int target) {
        Integer value = root.getValue();
        sum += value;
        queue.add(value);

        if (sum == target && root.getLeft() == null && root.getRight() == null) {
            List<Integer> list = new ArrayList<>(queue);
            result.add(list);
            queue.pop();
        } else {
            if (root.getLeft() != null)
                binaryTreePathSum(root.getLeft(), result, queue, sum, target);
            if (root.getRight() != null)
                binaryTreePathSum(root.getRight(), result, queue, sum, target);
            queue.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null, null, 1);
        root.setLeft(new TreeNode<>(null, null, 2));
        root.setRight(new TreeNode<>(null, null, 4));
        root.getLeft().setLeft(new TreeNode<>(null, null, 2));
        root.getLeft().setRight(new TreeNode<>(null, null, 3));

        List<List<Integer>> result = solution(root, 5);
        assert result.size() == 2;
        List<Integer> list1 = result.get(0);
        List<Integer> list2 = result.get(1);
        assert list1.get(0) == 1;
        assert list1.get(1) == 2;
        assert list1.get(2) == 2;
        assert list2.get(0) == 1;
        assert list2.get(1) == 4;
    }

}
