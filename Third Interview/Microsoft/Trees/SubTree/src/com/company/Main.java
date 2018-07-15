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

    public boolean isSubTree(TreeNode node1, TreeNode node2){

        if(node2 == null)
            return true;

        if(node1 == null)
            return false;

        if(isIdentical(node1, node2))
            return true;

        return (isSubTree(node1.left, node2) || isSubTree(node1.right, node2));
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2){

        if(node1 == null && node2 == null)
            return true;

        if(node1 == null || node2 == null)
            return false;

        return (node1.val == node2.val &&
        isIdentical(node1.left, node2.left) &&
        isIdentical(node1.right, node2.right));
    }
}