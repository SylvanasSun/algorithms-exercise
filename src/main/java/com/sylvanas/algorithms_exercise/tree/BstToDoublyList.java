package com.sylvanas.algorithms_exercise.tree;

/**
 * 将二叉查找树转换成双链表
 * 将一个二叉查找树按照中序遍历转换成双向链表。
 *
 * Created by SylvanasSun on 10/5/2017.
 */
public class BstToDoublyList {

    public static DoublyListNode solution(TreeNode<Integer> root) {
        if (root == null)
            return null;

        DoublyListNode node = buildDoublyListNode(root);
        while (node.prev != null)
            node = node.prev;
        return node;
    }

    private static DoublyListNode buildDoublyListNode(TreeNode<Integer> root) {
        if (root == null)
            return null;

        DoublyListNode midNode = new DoublyListNode(root.getValue());
        // 找到最左子树,并构建链表的左端
        if (root.getLeft() != null) {
            DoublyListNode left = buildDoublyListNode(root.getLeft());
            while (left.next != null)
                left = left.next;
            midNode.prev = left;
            left.next = midNode;
        }
        // 找到最右子树,并构建链表的右端
        if (root.getRight() != null) {
            DoublyListNode right = buildDoublyListNode(root.getRight());
            while (right.prev != null)
                right = right.prev;
            midNode.next = right;
            right.prev = midNode;
        }

        return midNode;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null, null, 4);
        root.setLeft(new TreeNode<>(null, null, 2));
        root.setRight(new TreeNode<>(null, null, 5));
        root.getLeft().setLeft(new TreeNode<>(null, null, 1));
        root.getLeft().setRight(new TreeNode<>(null, null, 3));

        DoublyListNode listNode = solution(root);
        assert listNode.val == 1;
        assert listNode.next.val == 2;
        listNode = listNode.next;
        assert listNode.prev.val == 1;
        assert listNode.next.val == 3;
        listNode = listNode.next;
        assert listNode.prev.val == 2;
        assert listNode.next.val == 4;
        listNode = listNode.next;
        assert listNode.prev.val == 3;
        assert listNode.next.val == 5;
        listNode = listNode.next;
        assert listNode.prev.val == 4;
        assert listNode.next == null;
    }

}
