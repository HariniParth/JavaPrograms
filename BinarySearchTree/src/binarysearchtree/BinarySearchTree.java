/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

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

public class BinarySearchTree {

    /**
     * @param root
     * @param min
     * @param max
     * @return 
     */
    Node root;
    
    public boolean isBinarySearch(Node root, int min, int max){
        if(root == null)
            return true;
        else if(root.value < min || root.value > max)
            return false;
        else
            return isBinarySearch(root.left,min,root.value) && isBinarySearch(root.right,root.value,max);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        System.out.println("Is Tree a BST -> "+tree.isBinarySearch(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    
}
