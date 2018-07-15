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

    class Node {
        int maxPath;
        int maxSum;
    }

    public int maxPathSum(TreeNode node){
        Node n = maxPathSumUtil(node);
        return n.maxSum;
    }

    public Node maxPathSumUtil(TreeNode node){
        if(node == null)
            return null;

        if(node.left == null && node.right == null){
            Node n = new Node();
            n.maxPath = node.val;
            n.maxSum = node.val;
            return n;
        }

        Node n = new Node();
        Node left = maxPathSumUtil(node.left);
        Node right = maxPathSumUtil(node.right);

        if(left == null){
            n.maxPath = Math.max(node.val, right.maxPath);
            n.maxSum = Math.max(n.maxPath, right.maxSum);
        }
        else if(right == null){
            n.maxPath = Math.max(node.val, left.maxPath);
            n.maxSum = Math.max(n.maxPath, left.maxSum);
        }
        else {
            n.maxPath = Math.max(left.maxPath, right.maxPath) + node.val;
            n.maxSum = Math.max(n.maxPath, left.maxSum);
            n.maxSum = Math.max(n.maxSum, right.maxSum);
            n.maxSum = Math.max(n.maxSum, left.maxPath+right.maxPath+node.val);
        }

        n.maxPath = Math.max(n.maxPath, node.val);
        n.maxSum = Math.max(n.maxSum, n.maxPath);
        return n;
    }
}
