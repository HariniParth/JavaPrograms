package com.company;

import java.util.*;

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

    public ArrayList<Integer> PostOrderTraversal(TreeNode node){

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;

        while(!stack.isEmpty() && node != null){

            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peek = stack.peek();
                if(peek.right != null && last != peek)
                    node = peek.right;
                else {
                    result.add(peek.val);
                    last = stack.pop();
                }
            }
        }

        return result;
    }
}
