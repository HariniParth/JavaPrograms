package com.company;

// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

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

    public int printKDistance(TreeNode node, TreeNode target, int k){

        if(node == null)
            return -1;

        if(node == target){
            printKDistanceDown(node, k);
            return 0;
        }

        int dLeft = printKDistance(node.left, target, k);
        if(dLeft != -1){
            if(dLeft+1 == k)
                System.out.print(node.val);
            else
                printKDistanceDown(node.right, k-dLeft-2);

            return 1+dLeft;
        }
        int dRight = printKDistance(node.right, target, k);
        if(dRight != -1){
            if(dRight+1 == k)
                System.out.print(node.val);
            else
                printKDistanceDown(node.left, k-dRight-2);

            return 1+dRight;
        }
        return -1;
    }

    private void printKDistanceDown(TreeNode node, int k){

        if(node == null || k < 0)
            return;

        if(k == 0){
            System.out.print(node.val);
            return;
        }

        printKDistanceDown(node.left, k-1);
        printKDistanceDown(node.right, k-1);
    }
}