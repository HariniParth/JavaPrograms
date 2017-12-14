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

    public int KthSmallest(TreeNode node, int k){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        int result = 0;

        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                TreeNode q = stack.pop();
                k--;
                if(k == 0)
                    result = q.val;
                p = q.right;
            }
        }

        return result;
    }
}
