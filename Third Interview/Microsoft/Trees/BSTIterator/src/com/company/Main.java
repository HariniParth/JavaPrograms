package com.company;

import java.util.*;

// https://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/

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

    Stack<TreeNode> stack;

    private void stackIterator(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    private boolean hasNext(){
        return !stack.isEmpty();
    }

    private int next(){
        TreeNode node = stack.pop();
        int result = node.val;
        while(node.right != null){
            node = node.right;
            if(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}