package com.sylvanas.algorithms_exercise.tree;

/**
 * 有两个不同大小的二叉树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
 * 若 T1 中存在从节点 n 开始的子树与 T2 相同，我们称 T2 是 T1 的子树。也就是说，
 * 如果在 T1 节点 n 处将树砍断，砍断的部分将与 T2 完全相同。
 *
 * Created by SylvanasSun on 9/28/2017.
 */
public class Subtree {

    public static boolean solution(TreeNode T1, TreeNode T2) {
        if (T2 == null)
            return true;
        if (T1 == null)
            return false;

        boolean result = false;
        // 如果T1和T2的根节点相同,那么开始比较两棵树的每个节点
        if (T1.getValue() == T2.getValue())
            result = depthCompare(T1, T2);
        // 否则递归调用该函数(从T1的左树和右树)
        if (!result)
            result = solution(T1.getLeft(), T2);
        if (!result)
            result = solution(T1.getRight(), T2);

        return result;
    }

    /**
     * 通过递归来深度比较两个树的所有节点是否相同
     */
    private static boolean depthCompare(TreeNode T1, TreeNode T2) {
        if (T1 != null && T2 != null && T1.getValue() == T2.getValue())
            return depthCompare(T1.getLeft(), T2.getLeft()) && depthCompare(T1.getRight(), T2.getRight());
        return T1 == null && T2 == null;
    }

}
