package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 * 挑战1：只使用一个队列去实现它
 * 挑战2：用DFS算法来做
 *
 * Created by SylvanasSun on 10/5/2017.
 */
public class LevelOrder {

    /**
     * 使用队列实现广度优先搜索,把每层的值都加入一个List中.
     */
    public static List<List<Integer>> solution(TreeNode<Integer> root) {
        if (root == null)
            new ArrayList<>();

        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                list.add(node.getValue());

                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }

            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null, null, 3);
        root.setLeft(new TreeNode<Integer>(null, null, 9));
        root.setRight(new TreeNode<Integer>(null, null, 20));
        root.getRight().setLeft(new TreeNode<Integer>(null, null, 15));
        root.getRight().setRight(new TreeNode<Integer>(null, null, 7));

        List<List<Integer>> result = solution(root);
        assert result.size() == 3;
        List<Integer> list_1 = result.get(0);
        List<Integer> list_2 = result.get(1);
        List<Integer> list_3 = result.get(2);
        assert list_1.get(0) == 3;
        assert list_2.get(0) == 9;
        assert list_2.get(1) == 20;
        assert list_3.get(0) == 15;
        assert list_3.get(1) == 7;
    }

}
