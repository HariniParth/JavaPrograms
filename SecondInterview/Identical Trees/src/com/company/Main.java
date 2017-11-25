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

    public int identical(TreeNode a, TreeNode b){

        if(a == null && b == null)
            return 1;

        if(a == null || b == null)
            return 0;

        if(a.val != b.val)
            return 0;

        return identical(a.left, b.left) & identical(a.right, b.right);
    }
}
