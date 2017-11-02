package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 *
 * Created by SylvanasSun on 11/2/2017.
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // 交替使用两个栈
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        boolean orderFlag = true;

        currentStack.push(root);
        while (!currentStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            while (!currentStack.isEmpty()) {
                TreeNode node = currentStack.pop();
                list.add((Integer) node.value);

                if (orderFlag) {
                    if (node.left != null)
                        nextStack.push(node.left);
                    if (node.right != null)
                        nextStack.push(node.right);
                } else {
                    if (node.right != null)
                        nextStack.push(node.right);
                    if (node.left != null)
                        nextStack.push(node.left);
                }
            }

            tempStack = currentStack;
            currentStack = nextStack;
            nextStack = tempStack;
            orderFlag = !orderFlag;
            result.add(list);
        }

        return result;
    }

}
