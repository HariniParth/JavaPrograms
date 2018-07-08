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

    public void commonElements(TreeNode node1, TreeNode node2){

        if(node1 == null || node2 == null)
            return;

        Stack<TreeNode> p = new Stack<>();
        Stack<TreeNode> q = new Stack<>();

        TreeNode n1 = node1;
        TreeNode n2 = node2;

        while(true){
            if(n1 != null){
                p.push(n1);
                n1 = n1.left;
            }
            else if(n2 != null){
                q.push(n2);
                n2 = n2.left;
            }
            else if(!p.isEmpty() && !q.isEmpty()){
                n1 = p.peek();
                n2 = q.peek();

                if(n1.val < n2.val){
                    p.pop();
                    n1 = n1.right;
                    n2 = null;
                }
                else if(n2.val < n1.val){
                    q.pop();
                    n2 = n2.right;
                    n1 = null;
                }
                else {
                    System.out.print(n1.val);
                    p.pop();
                    q.pop();
                    n1 = n1.right;
                    n2 = n2.right;
                }
            }
            else
                break;
        }
    }
}