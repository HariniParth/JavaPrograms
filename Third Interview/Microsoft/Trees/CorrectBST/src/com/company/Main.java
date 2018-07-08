package com.company;

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

    TreeNode first, mid, last, prev;

    public void correct(TreeNode node){

        first = mid = last = prev = null;

        correctUtil(node);

        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && mid != null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    public void correctUtil(TreeNode node){

        if(node != null){

            correctUtil(node.left);

            if(prev != null && node.val < prev.val){
                if(first == null){
                    first = prev;
                    mid = node;
                } else
                    last = node;
            }
            prev = node;

            correctUtil(node.right);
        }
    }
}