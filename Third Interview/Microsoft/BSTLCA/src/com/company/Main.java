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

    public TreeNode LCA(TreeNode node, int n1, int n2){

        if(node == null)
            return null;

        if(node.val > n1 && node.val > n2)
            return LCA(node.left, n1, n2);

        if(node.val < n1 && node.val < n2)
            return LCA(node.right, n1, n2);

        return node;
    }
}