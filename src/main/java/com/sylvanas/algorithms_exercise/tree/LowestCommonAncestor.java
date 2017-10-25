package com.sylvanas.algorithms_exercise.tree;

/**
 * 最近公共祖先
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 *
 * Created by SylvanasSun on 10/25/2017.
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return null;
        if (root == A || root == B)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

}
