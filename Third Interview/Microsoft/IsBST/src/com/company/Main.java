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

    public boolean isBST(TreeNode node){
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTUtil(TreeNode node, int min, int max){

        if(node == null)
            return true;
        if(node.val < min && node.val > max)
            return false;

        return isBSTUtil(node.left, Integer.MIN_VALUE, node.val - 1) &
                isBSTUtil(node.right, node.val + 1, Integer.MAX_VALUE);
    }
}