/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lca;

/**
 *
 * @author harini-geek
 */
public class LCA {

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
    
    Node lca(Node node, int n1, int n2){
        
        if(node == null)
            return null;
        
        if(node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);
        
        if(node.data < n1 && node.data < n2)
            return lca(node.right, n1, n2);
        
        return node;
    }
    
    public static void main(String[] args) {
        
        LCA tree = new LCA();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        
        Node node = tree.lca(tree.root, 4, 6);
        System.out.println("LCA "+node.data);
    }
    
}
