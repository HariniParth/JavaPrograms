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

    public boolean isMirror(TreeNode node){

        return isMirrorUtil(node, node);
    }

    public boolean isMirrorUtil(TreeNode node1, TreeNode node2){

        if(node1 == null && node2 == null)
            return true;

        if(node1 != null && node2 != null && node1.val == node2.val)
            return isMirrorUtil(node1.left, node2.right) &
                    isMirrorUtil(node1.right, node2.left);

        return false;
    }
}