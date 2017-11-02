package com.sylvanas.algorithms_exercise.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 *
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
 *
 * Created by SylvanasSun on 11/2/2017.
 */
public class SerializeAndDeserialize {

    static Queue<TreeNode> serializeQueue = new ArrayDeque<>();

    static Queue<TreeNode> deserializeQueue = new ArrayDeque<>();

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#");
            return sb.toString();
        }

        serializeQueue.add(root);
        sb.append(root.value).append(",");
        TreeNode node;
        TreeNode left;
        TreeNode right;
        while (!serializeQueue.isEmpty()) {
            node = serializeQueue.poll();
            left = node.left;
            if (left == null) {
                sb.append("#,");
            } else {
                sb.append(left.value).append(",");
                serializeQueue.add(left);
            }
            right = node.right;
            if (right == null) {
                sb.append("#,");
            } else {
                sb.append(right.value).append(",");
                serializeQueue.add(right);
            }
        }

        // 去掉最后一个逗号
        return sb.toString().substring(0, sb.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || "#".equals(data))
            return null;

        String[] strings = data.split(",");
        TreeNode root = new TreeNode();
        root.value = Integer.valueOf(strings[0]);
        int i = 1;
        deserializeQueue.add(root);

        int length = strings.length;
        while (!deserializeQueue.isEmpty() && i < length) {
            TreeNode node = deserializeQueue.poll();
            if ("#".equals(strings[i])) {
                node.left = null;
                i++;
            } else {
                TreeNode left = new TreeNode();
                left.value = Integer.valueOf(strings[i]);
                node.left = left;
                deserializeQueue.add(left);
                i++;
            }
            if (i < length && "#".equals(strings[i])) {
                node.right = null;
                i++;
            } else if (i < length) {
                TreeNode right = new TreeNode();
                right.value = Integer.valueOf(strings[i]);
                node.right = right;
                deserializeQueue.add(right);
                i++;
            }
        }

        return root;
    }

}
