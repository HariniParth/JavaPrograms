package com.company;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    public boolean isCompleteBST(TreeNode root){
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);

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
                flag = false;
        }
        return true;
    }
}
