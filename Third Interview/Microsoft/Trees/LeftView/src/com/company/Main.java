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

    TreeNode root;
    static int maxLevel = 0;

    public void leftView(){
        leftViewUtil(root, 1);
    }

    private void leftViewUtil(TreeNode node, int level){
        if(node == null)
            return;

        if(maxLevel < level){
            System.out.print(node.val);
            maxLevel = level;
        }

        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
    }
}