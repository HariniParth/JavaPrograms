package com.company;

// https://gist.github.com/kanrourou/7c39c5af15bf20946e3b

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

    public int getDistance(TreeNode root, TreeNode node1, TreeNode node2){

        if(root == null || node1 == null || node2 == null)
            return -1;

        TreeNode parent = LCA(root, node1, node2);
        int depth1 = getDepth(root, parent);
        int depth2 = getDepth(root, node1);
        int depth3 = getDepth(root, node2);

        return depth2 + depth3 - 2*depth1;
    }

    private TreeNode LCA(TreeNode curr, TreeNode node1, TreeNode node2){

        if(curr == null)
            return null;
        if(curr == node1 || curr == node2)
            return curr;

        TreeNode left = LCA(curr.left, node1, node2);
        TreeNode right = LCA(curr.right, node1, node2);
        if(left != null && right != null)
            return curr;

        return (left == null)? right:left;
    }

    private int getDepth(TreeNode curr, TreeNode target){

        if(curr == null)
            return -1;
        if(curr == target)
            return 0;

        int left = getDepth(curr.left, target);
        int right = getDepth(curr.right, target);
        if(left == -1 && right == -1)
            return -1;

        return (left == -1)? right+1 : left+1;
    }
}
