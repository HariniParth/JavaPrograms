/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxpathsumbinarytree;

/**
 *
 * @author harini-geek
 */
class TreeNode{
    int val;
    TreeNode left, right;
    
    TreeNode(int n){
        val = n;
        left = null;
        right = null;
    }
}

public class MaxPathSumBinaryTree{
    
    class Node{
        int maxPath;
        int maxSum;
    }
    
    public int solution(TreeNode node){
        Node n = maxPathSum(node);
        return n.maxSum;
    }
    
    public Node maxPathSum(TreeNode node){
        if(node == null)
            return null;
        
        if(node.left == null && node.right == null){
            Node n = new Node();
            n.maxPath = node.val;
            n.maxSum = node.val;
            return n;
        }
        
        Node n = new Node();
        Node left = maxPathSum(node.left);
        Node right = maxPathSum(node.right);
        
        if(left == null){
            n.maxPath = node.val + right.maxPath;
            n.maxSum = Math.max(n.maxPath, right.maxSum);
        } else if(right == null){
            n.maxPath = node.val + left.maxPath;
            n.maxSum = Math.max(n.maxPath, left.maxSum);
        } else {
            n.maxPath = Math.max(left.maxPath, right.maxPath) + node.val;
            n.maxSum = Math.max(n.maxPath, right.maxSum);
            n.maxSum = Math.max(n.maxSum, left.maxSum);
            n.maxSum = Math.max(n.maxSum, left.maxPath + right.maxPath + node.val);
        }
        n.maxPath = Math.max(n.maxPath, node.val);
        n.maxSum = Math.max(n.maxSum, n.maxPath);
        
        return n;
    }
}