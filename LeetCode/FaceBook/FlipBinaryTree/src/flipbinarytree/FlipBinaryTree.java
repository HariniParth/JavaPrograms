/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipbinarytree;

/**
 *
 * @author harini-geek
 */

class TreeNode{
    int val;
    TreeNode left, right;
    
    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class FlipBinaryTree {

    public TreeNode flipBinaryTree(TreeNode root){
        if(root == null)
            return root;
        
        if(root.left == null && root.right == null)
            return root;
        
        TreeNode flippedRoot = flipBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return flippedRoot;
    }
}
