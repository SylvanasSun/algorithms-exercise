package com.sylvanas.algorithms_exercise.tree;

/**
 * 克隆二叉树
 * 深度复制一个二叉树。
 * 给定一个二叉树，返回一个他的 克隆品 。
 *
 * Created by SylvanasSun on 10/4/2017.
 */
public class CloneTree {

    public static TreeNode<Integer> solution(TreeNode<Integer> root) {
        if (root == null)
            return null;
        else {
            TreeNode<Integer> clone = new TreeNode<>(null, null, root.getValue());
            clone.setLeft(solution(root.getLeft()));
            clone.setRight(solution(root.getRight()));
            return clone;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null, null, 1);
        root.setLeft(new TreeNode<>(null, null, 4));
        root.setRight(new TreeNode<>(null, null, 3));
        root.getLeft().setLeft(new TreeNode<>(null, null, 10));

        TreeNode<Integer> clone = solution(root);
        assert clone.getValue() == 1;
        assert clone.getLeft().getValue() == 4;
        assert clone.getRight().getValue() == 3;
        assert clone.getLeft().getLeft().getValue() == 10;
    }

}
