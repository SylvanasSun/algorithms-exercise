package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 *
 * Created by SylvanasSun on 10/22/2017.
 */
public class MaxDepth {

    public static int maxDepth(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        // +1是因为需要计算自身当前的深度
        return left > right ? left + 1 : right + 1;
    }

    public static int maxDepthNotRecursive(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        // 二叉树层次遍历
        while (!queue.isEmpty()) {
            int len = queue.size(); // 记录每层的节点数
            depth++;
            while (len > 0) {
                TreeNode<Integer> node = queue.poll();
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
                len--;
            }
        }

        return depth;
    }

}
