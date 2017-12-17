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

    public int maxLevelSum(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int result = node.val;
        while(!queue.isEmpty()){
            int count = queue.size();
            int sum = 0;
            while(count-- >= 0){
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
