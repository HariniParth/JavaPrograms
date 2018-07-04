package com.company;

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

    TreeNode first, mid, last, prev;

    public void correctBST(TreeNode node){

        first = mid = last = prev = null;

        correctBSTUtil(node);

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

    public void correctBSTUtil(TreeNode node){
        if(node != null){
            correctBSTUtil(node.left);

            if(prev != null && prev.val > node.val){
                if(first == null){
                    first = prev;
                    mid = node;
                } else {
                    last = node;
                }
            }
            prev = node;

            correctBSTUtil(node.right);
        }
    }
}
