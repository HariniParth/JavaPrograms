package com.company;

// https://www.geeksforgeeks.org/flip-binary-tree/

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

    public TreeNode flippedTree(TreeNode node){

        if(node == null)
            return null;

        if(node.left == null && node.right == null)
            return node;

        TreeNode flippedNode = flippedTree(node.left);

        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;
        
        return flippedNode;
    }
}
