/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumdepth;

/**
 *
 * @author harini-geek
 */
public class MinimumDepth {

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
    
    int minimumDepth(){
        return minimumDepth(root);
    }
    
    int minimumDepth(Node root){
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        if(root.left == null)
            return minimumDepth(root.right) + 1;
        
        if(root.right == null)
            return minimumDepth(root.left) + 1;
        
        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
    }
    
    public static void main(String[] args) {
        
        MinimumDepth tree = new MinimumDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        
        System.out.println("Depth "+tree.minimumDepth());
    }
    
}
