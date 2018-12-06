package com.company;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    private TreeNode removeShortNodes(TreeNode root, int k){
        return removeShortNodes(root, 1, k);
    }

    private TreeNode removeShortNodes(TreeNode node, int level, int k){

        if(node == null)
            return null;

        node.left = removeShortNodes(node.left, level+1, k);
        node.right = removeShortNodes(node.right, level+1, k);

        if(node.left == null && node.right == null && level < k)
            return null;

        return node;
    }
}
