package com.company;

// https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    public int findMaxForN(TreeNode node, int N){

        if(node.left == null && node.right == null && node.val > N)
            return -1;

        if((node.val < N && node.right == null) || (node.val < N && node.right.val > N))
            return node.val;

        if(node.val >= N)
            return findMaxForN(node.left, N);
        else
            return findMaxForN(node.right, N);
    }
}
