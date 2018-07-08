package com.company;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode nextRight;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
        nextRight = null;
    }
}

public class Main {

    public void connect(TreeNode node){

        node.nextRight = null;
        connectUtil(node);
    }

    public void connectUtil(TreeNode node){

        if(node == null)
            return;

        if(node.left != null)
            node.left.nextRight = node.right;

        if(node.right != null)
            node.right.nextRight = (node.nextRight != null)? node.nextRight.left : null;

        connectUtil(node.left);
        connectUtil(node.right);
    }
}