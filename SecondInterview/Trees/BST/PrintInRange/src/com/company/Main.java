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

    public void print(TreeNode node, int k1, int k2){

        if(node == null)
            return;

        if(k1 < node.val)
            print(node.left, k1, k2);

        if(k1 <= node.val && node.val <= k2)
            System.out.print(node.val+" ");

        if(k2 > node.val)
            print(node.right, k1, k2);

    }
}
