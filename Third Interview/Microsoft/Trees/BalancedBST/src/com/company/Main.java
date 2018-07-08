package com.company;

class TreeNode {
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

    public int balanced(TreeNode node){

        if(node == null)
            return 1;

        int left = balanced(node.left);
        int right = balanced(node.right);

        if(Math.abs(left - right) < 2 && height(node.left) == 1 && height(node.right) == 1)
            return 1;

        return 0;
    }

    public int height(TreeNode node){

        if(node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        return 1 + Math.max(left, right);
    }
}