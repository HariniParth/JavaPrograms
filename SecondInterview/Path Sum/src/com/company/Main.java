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

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode node, int sum){

        result = new ArrayList<>();
        recurse(node, sum, new ArrayList<>(), result);
        return result;
    }

    public void recurse(TreeNode node, int sum, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result){

        if(node == null)
            return;

        if(node.left == null && node.right == null){
            if(node.val == sum){
                current.add(node.val);
                result.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            }
        }

        current.add(node.val);
        sum -= node.val;
        recurse(node.left, sum, current, result);
        recurse(node.right, sum, current, result);
        current.remove(current.size()-1);
    }
}
