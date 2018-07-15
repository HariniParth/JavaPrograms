package com.company;

// https://algorithms.tutorialhorizon.com/find-the-distance-from-root-to-given-node-of-a-binary-tree/

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

    public int DistanceRootToNode(TreeNode root, int n){

        if(root != null){
            int x = 0;
            if(root.val == n
                    || (x = DistanceRootToNode(root.left, n)) > 0
                    || (x = DistanceRootToNode(root.right, x)) > 0){
                return (x+1);
            }
            return 0;
        }
        return 0;
    }
}
