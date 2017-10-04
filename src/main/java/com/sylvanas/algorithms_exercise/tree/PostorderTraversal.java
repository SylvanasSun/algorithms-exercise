package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 给出一棵二叉树，返回其节点值的后序遍历。
 *
 * Created by SylvanasSun on 10/4/2017.
 */
public class PostorderTraversal {

    public static List<Integer> solution(TreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private static void postorderTraversal(TreeNode<Integer> root, List<Integer> result) {
        if (root.getLeft() != null)
            postorderTraversal(root.getLeft(), result);
        if (root.getRight() != null)
            postorderTraversal(root.getRight(), result);
        result.add(root.getValue());
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null, null, 1);
        root.setRight(new TreeNode<>(null, null, 2));
        root.getRight().setLeft(new TreeNode<>(null, null, 3));

        List<Integer> result = solution(root);
        assert result.get(0) == 3;
        assert result.get(1) == 2;
        assert result.get(2) == 1;
    }

}
