package com.sylvanas.algorithms_exercise.tree;

/**
 * 使用一棵树的前序遍历数组与中序遍历数组来构造一棵二叉树.
 *
 * Created by SylvanasSun on 9/13/2017.
 */
public class UsePreorderAndInorderConstructionTree {

    public static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode<Integer> buildTree(int[] preorder, int[] inorder,
                                               int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end)
            return null;

        // 前序遍历的第一个元素即是根节点
        TreeNode<Integer> root = new TreeNode<>(null, null, preorder[pre_start]);
        int divider = 0; // 用于切分左右子树

        // 切分中序遍历数组,在根节点左边的即是左子树,右边的即是右子树
        while (divider <= in_end && inorder[divider] != root.getValue())
            divider++;

        int offset = divider - 1 - in_start;

        root.setLeft(buildTree(preorder, inorder, pre_start + 1, pre_start + 1 + offset,
                in_start, in_start + offset));
        root.setRight(buildTree(preorder, inorder, pre_start + 2 + offset, pre_end, divider + 1, in_end));

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {2, 1, 3};
        int[] inorder = {1, 2, 3};
        TreeNode<Integer> tree = buildTree(preorder, inorder);

        assert tree.getValue() == 2;
        assert tree.getLeft().getValue() == 1;
        assert tree.getRight().getValue() == 3;
    }

}
