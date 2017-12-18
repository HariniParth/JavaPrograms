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

    public TreeNode TreeToList(TreeNode node){
        if(node == null)
            return null;

        if(node.left != null){
            TreeNode left = TreeToList(node.left);
            for(;left.right != null; left = left.right);
            left.right = node;
            node.left = left;
        }

        if(node.right != null){
            TreeNode right = TreeToList(node.right);
            for(;right.left != null; right = right.left);
            right.left = node;
            node.right = right;
        }

        return node;
    }

}
