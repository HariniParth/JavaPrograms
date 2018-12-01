package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    private boolean isCompleteBST(TreeNode node){

        if(node == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode parent = queue.remove();
            if(parent.left != null){
                if(flag == true)
                    return false;
                queue.add(parent.left);
            } else
                flag = true;

            if(parent.right != null){
                if(flag == true)
                    return false;
                queue.add(parent.right);
            } else
                flag = true;
        }
        return true;
    }
}