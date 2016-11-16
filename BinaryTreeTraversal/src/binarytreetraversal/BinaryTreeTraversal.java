/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreetraversal;

/**
 *
 * @author harini-geek
 */

class Node{
    int value;
    Node left, right;
    
    Node(int value){
        this.value = value;
        left = right = null;
    }
}

public class BinaryTreeTraversal {

    /**
     * @param args the command line arguments
     */
    Node root;
    
    private void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }
    
    private void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }
    
    private void preOrder(Node root){
        if(root != null){
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        
        System.out.println("In Order");
        tree.inOrder(tree.root);
        System.out.println("Pre Order");
        tree.preOrder(tree.root);
        System.out.println("Post Order");
        tree.postOrder(tree.root);
    }
    
}
