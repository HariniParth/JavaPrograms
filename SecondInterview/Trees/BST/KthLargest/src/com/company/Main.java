package com.company;

// https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class Main {

    TreeNode root;

    class Count{
        int c = 0;
    }

    void KthLargest(int k){
        Count count = new Count();
        this.KthLargestUtil(this.root, count, k);
    }

    void KthLargestUtil(TreeNode node, Count count, int k){
        if(node == null || count.c >= k)
            return;

        this.KthLargestUtil(node.right, count, k);

        count.c++;

        if(count.c == k){
            System.out.println("Kth Largest Element is: "+node.val);
            return;
        }

        this.KthLargestUtil(node.left, count, k);
    }
}
