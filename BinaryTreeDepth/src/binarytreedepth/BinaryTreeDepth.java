/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreedepth;

/**
 *
 * @author harini-geek
 */

class Node{
    int data;
    Node left, right;
    
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeDepth {

    /**
     * @param args the command line arguments
     */
    
    Node root;
    
    static int maximumDepth(Node root){
        if(root == null)
            return 0;
        else
            return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;
    }
    
    static int minimumDepth(Node root){
        if(root == null)
            return 0;
        else
            return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
    }
            
    public static void main(String[] args){
        
        BinaryTreeDepth tree = new BinaryTreeDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Max Depth "+maximumDepth(tree.root));
        System.out.println("Min Depth "+minimumDepth(tree.root));
    }
 
}
