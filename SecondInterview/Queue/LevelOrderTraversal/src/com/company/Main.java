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

    public void levelTraversal(TreeNode node){
        if(node == null)
            return;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(node);
        while(!q1.isEmpty() && !q2.isEmpty()){
            while(!q1.isEmpty()){
                if(q1.peek().left != null)
                    q2.add(q1.peek().left);
                if(q1.peek().right != null)
                    q2.add(q1.peek().right);

                System.out.println(q1.peek().val);
                q1.remove();
            }

            while(!q2.isEmpty()){
                if(q2.peek().left != null)
                    q1.add(q2.peek().left);
                if(q2.peek().right != null)
                    q1.add(q2.peek().right);

                System.out.println(q2.peek().val);
                q2.remove();
            }
        }
    }
}
