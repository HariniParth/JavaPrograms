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

    public TreeNode insert(TreeNode node, int data){

        if(node == null){
            return (new TreeNode(data));
        } else {
            if(data <= node.val){
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public int minValue(TreeNode node){

        TreeNode curr = node;

        while (curr.left != null)
            curr = curr.left;

        return curr.val;
    }
}
