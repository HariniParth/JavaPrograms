/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removenode;

/**
 *
 * @author harini-geek
 */
class Node{
    
    int data;
    Node next;
    
    Node(int d){
        data = d;
        next = null;
    }
}

public class RemoveNode {

    /**
     * @param args the command line arguments
     */
    Node head;
    
    void removeNode(Node node, Node n){
        if(node == n){
            if(node.next == null){
                System.out.println("Only one node present, cannot remove!");
            } else {
                node.data = node.next.data;
                node.next = node.next.next;
                System.gc();
            }
        } else {
            Node prev = node;
            while(prev.next != null && prev.next != n){
                prev = prev.next;
            }
            if(prev.next == null)
                System.out.println("Node not present");
            else {
                prev.next = prev.next.next;
                System.gc();
            }
        }
    }
    
    void printList(Node head){
        while(head != null){
            System.out.println("Node "+head.data);
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        
        RemoveNode list = new RemoveNode();
        list.head = new Node(5);
        list.head.next = new Node(3);
        list.head.next.next = new Node(4);
        list.printList(list.head);
        list.removeNode(list.head, list.head);
        list.printList(list.head);
        list.removeNode(list.head, list.head.next);

    }
    
}
