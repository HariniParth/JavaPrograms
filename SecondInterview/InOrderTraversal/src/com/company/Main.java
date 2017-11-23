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

    public ArrayList<Integer> inOrder(TreeNode node){

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(true){

            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()){
                    break;
                }

                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

}
