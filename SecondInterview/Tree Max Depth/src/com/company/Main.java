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

    public int maximum(TreeNode node){

        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 1;

        return Math.max(maximum(node.left), maximum(node.right)) + 1;
    }
}
