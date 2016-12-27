/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullbinarytree;

/**
 *
 * @author harini-geek
 */
public class FullBinaryTree {

    Node root;
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }
    
    boolean isFullTree(Node root){
        
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null)
            return true;
        
        if(root.left != null && root.right != null)
            return (isFullTree(root.left) && isFullTree(root.right));
        
        return false;
    }
    
    public static void main(String[] args) {
        
        FullBinaryTree tree = new FullBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(1);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(1);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(1);
        if(tree.isFullTree(tree.root))
            System.out.println("Full Tree");
    }
    
}
