package com.company;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    public int getMaxWidth(TreeNode node){
        int maxWidth = 0;
        int width;
        int i;
        int h = getHeight(node);

        for(i=0;i<h;i++){
            width = getWidth(node, i);
            if(width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    public int getWidth(TreeNode node, int level){
        if(node == null)
            return 0;

        if(level == 1)
            return 1;

        if(level > 1)
            return getWidth(node.left, level-1) + getWidth(node.right, level-1);

        return 0;
    }

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);

            return (left > right)? left + 1 : right + 1;
        }
    }
}
