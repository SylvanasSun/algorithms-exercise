package com.sylvanas.algorithms_exercise.tree;

/**
 * Created by SylvanasSun on 9/13/2017.
 */
public class TreeNode<Value> {

    Value value;

    TreeNode<Value> left;

    TreeNode<Value> right;

    public TreeNode(TreeNode<Value> left, TreeNode<Value> right, Value value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public TreeNode<Value> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<Value> left) {
        this.left = left;
    }

    public TreeNode<Value> getRight() {
        return right;
    }

    public void setRight(TreeNode<Value> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        if (value != null ? !value.equals(treeNode.value) : treeNode.value != null) return false;
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
        return right != null ? right.equals(treeNode.right) : treeNode.right == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
