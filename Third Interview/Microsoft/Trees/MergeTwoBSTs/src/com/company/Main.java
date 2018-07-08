package com.company;

import java.util.*;

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

    private void InOrder(TreeNode node){

        if(node == null)
            return;

        InOrder(node.left);
        System.out.print(node.val);
        InOrder(node.right);
    }

    public void mergeTwoBSTs(TreeNode node1, TreeNode node2){

        Stack<TreeNode> p = new Stack<>();
        Stack<TreeNode> q = new Stack<>();

        TreeNode n1 = node1;
        TreeNode n2 = node2;

        while(!p.isEmpty() || !q.isEmpty() || n1 != null || n2 != null){
            if(n1 != null || n2 != null){
                if(n1 != null){
                    p.push(n1);
                    n1 = n1.left;
                }
                if(n2 != null){
                    q.push(n2);
                    n2 = n2.left;
                }
            }
            else {
                if(p.isEmpty()){
                    while(!q.isEmpty()){
                        n2 = q.pop();
                        n2.left = null;
                        InOrder(n2);
                    }
                    return;
                }
                if(q.isEmpty()){
                    while(!p.isEmpty()){
                        n1 = p.pop();
                        n1.left = null;
                        InOrder(n1);
                    }
                    return;
                }
                n1 = p.pop();
                n2 = q.pop();

                if(n1.val < n2.val){
                    System.out.print(n1.val);
                    n1 = n1.right;
                    q.push(n2);
                    n2 = null;
                } else {
                    System.out.print(n2.val);
                    n2 = n2.right;
                    p.push(n1);
                    n1 = null;
                }
            }
        }
    }
}