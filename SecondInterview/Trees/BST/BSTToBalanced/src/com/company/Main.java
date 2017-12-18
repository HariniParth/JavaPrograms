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

    public void storeNode(TreeNode node, ArrayList<TreeNode> list){
        if(node == null)
            return;

        storeNode(node.left, list);
        list.add(node);
        storeNode(node.right, list);
    }

    public TreeNode buildNodeUtil(ArrayList<TreeNode> list, int start, int end){
        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode node = list.get(mid);
        node.left = buildNodeUtil(list, start, mid-1);
        node.right = buildNodeUtil(list, mid+1, end);
        return node;    
    }

    public TreeNode buildNode(TreeNode node){
        ArrayList<TreeNode> list = new ArrayList<>();
        storeNode(node, list);
        int n = list.size();
        return buildNodeUtil(list, 0, n-1);
    }
}
