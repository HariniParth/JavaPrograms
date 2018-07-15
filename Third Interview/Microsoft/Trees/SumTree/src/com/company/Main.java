package com.company;

// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

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

    public int isSumTree(TreeNode node){

        if(node == null || (node.left == null && node.right == null))
            return 1;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        if(node.val == leftSum + rightSum && isSumTree(node.left) != 0 && isSumTree(node.right) != 0)
            return 1;

        return 0;
    }

    private int sum(TreeNode node){
        if(node == null)
            return 0;

        return sum(node.left) + node.val + sum(node.right);
    }
}