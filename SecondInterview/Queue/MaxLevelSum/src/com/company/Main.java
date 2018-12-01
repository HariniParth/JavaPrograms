package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    private int maxLevelSum(TreeNode node){

        if(node == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(node);

        while(!queue.isEmpty()){
            int sum = 0;
            int count = 0;
            while(count-- > 0){
                TreeNode n = queue.peek();
                queue.remove();

                sum = sum + n.val;
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}