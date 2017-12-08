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

    public int minimum(TreeNode node){

        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 1;

        int left = (node.left != null)? minimum(node.left) : Integer.MAX_VALUE;
        int right = (node.right != null)? minimum(node.right) : Integer.MAX_VALUE;

        return 1 + Math.min(left, right);
    }
}
