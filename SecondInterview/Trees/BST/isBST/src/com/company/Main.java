package com.company;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    public boolean isBST(TreeNode node){
        return BST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean BST(TreeNode node, int min, int max){
        if(node == null)
            return true;

        if(node.val < min || node.val > max)
            return false;

        return BST(node.left, min, node.val-1) & BST(node.right, node.val+1, max);
    }
}
