package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    public void Inorder(TreeNode node){
        if(node == null)
            return;
        Inorder(node.left);
        System.out.println(node.val);
        Inorder(node.right);
    }

    public void mergeLists(TreeNode node1, TreeNode node2){
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
                        Inorder(n2);
                    }
                    return;
                }
                if(q.isEmpty()){
                    while(!p.isEmpty()){
                        n1 = q.pop();
                        n1.left = null;
                        Inorder(n1);
                    }
                    return;
                }
                n1 = p.pop();
                n2 = q.pop();

                if(n1.val < n2.val){
                    System.out.println(n1.val);
                    n1 = n1.right;
                    q.push(n2);
                    n2 = null;
                } else {
                    System.out.println(n2.val);
                    n2 = n2.right;
                    p.push(n1);
                    n1 = null;
                }
            }
        }
    }
}
