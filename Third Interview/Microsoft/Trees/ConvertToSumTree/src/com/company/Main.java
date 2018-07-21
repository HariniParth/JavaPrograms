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

    public int toSumTree(TreeNode node){

        if(node == null)
            return 0;

        int val = node.val;
        node.val = toSumTree(node.left) + toSumTree(node.right);
        return val + node.val;
    }
}
