package com.company;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    private int maxLessThanN(TreeNode node, int n){

        if(node.left == null && node.val >= n)
            return -1;

        if((node.val < n && node.right == null) || (node.val < n && node.right.val >= n))
            return node.val;

        if(node.val >= n)
            return maxLessThanN(node.left, n);
        else
            return maxLessThanN(node.right, n);
    }
}
