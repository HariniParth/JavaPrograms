package com.company;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;

        while(true){
            int nodeCount = queue.size();
            if(nodeCount == 0)
                return height;
            height++;

            while(nodeCount > 0){
                TreeNode n = queue.peek();
                queue.remove();
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
                nodeCount--;
            }
        }
    }
}
