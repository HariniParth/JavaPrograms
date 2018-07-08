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

    TreeNode root;

    private class Count {
        int c = 0;
    }

    public void KthLargest(int k){

        Count count = new Count();
        this.KthLargestUtil(root, count, k);
    }

    public void KthLargestUtil(TreeNode node, Count count, int k){

        if(node == null || count.c >= k)
            return;

        KthLargestUtil(node.right, count, k);

        count.c++;

        if(count.c == k){
            System.out.print(node.val);
            return;
        }

        KthLargestUtil(node.left, count, k);
    }
}