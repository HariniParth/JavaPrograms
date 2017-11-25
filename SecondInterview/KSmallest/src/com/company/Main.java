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

    ArrayList<Integer> list;

    public int smallest(TreeNode node, int k){

        list = new ArrayList<>();
        inOrder(node);
        return list.get(k-1);
    }

    public void inOrder(TreeNode node){

        if(node != null){
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }
}
