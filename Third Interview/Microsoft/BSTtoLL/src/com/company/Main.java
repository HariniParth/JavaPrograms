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

    TreeNode head;

    static TreeNode prev;

    public void convert(TreeNode node){

        if(node == null)
            return;

        convert(node.left);

        if(prev == null)
            head = node;
        else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        convert(node.right);
    }
}