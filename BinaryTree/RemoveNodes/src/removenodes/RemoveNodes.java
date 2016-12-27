/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removenodes;

/**
 *
 * @author harini-geek
 */
public class RemoveNodes {

    Node root;
    
    static class Node {
        int data;
        Node right, left;
        
        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }
    
    Node removeShortNodes(Node node, int level, int k){
        
        if(node == null)
            return null;
        
        node.left = removeShortNodes(node.left, level+1, k);
        node.right = removeShortNodes(node.right, level+1, k);
        
        if(node.left == null && node.right == null && level < k)
            return null;
        
        return node;
    }
    
    Node removeShortNodes(Node node, int k){
        return removeShortNodes(node, 1, k);
    }
    
    void printInOrder(Node node){
        
        if(node != null){
            printInOrder(node.left);
            System.out.print(node.data+" ");
            printInOrder(node.right);
        }
    }
    
    public static void main(String[] args) {
        
        RemoveNodes list = new RemoveNodes();
        list.root = new Node(1);
        list.root.left = new Node(2);
        list.root.right = new Node(3);
        list.root.left.left = new Node(4);
        list.root.left.right = new Node(5);
        list.root.right.right = new Node(6);
        list.root.right.left = new Node(7);
        
        list.printInOrder(list.root);
        list.removeShortNodes(list.root, 2);
        list.printInOrder(list.root);
    }
    
}
