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

    public void printPath(TreeNode node){
        int[] path = new int[1000];
        printArrayRecurse(node, path, 0);
    }

    public void printArrayRecurse(TreeNode node, int[] path, int len){
        if(node == null)
            return;
        path[len] = node.val;
        len++;

        if(node.left == null && node.right == null)
            printArray(path, len);
        else {
            printArrayRecurse(node.left, path, len);
            printArrayRecurse(node.right, path, len);
        }
    }

    public void printArray(int[] path, int len){
        int i;
        for(i=0;i<len;i++)
            System.out.print(path[i]+" ");
        System.out.println();
    }
}
