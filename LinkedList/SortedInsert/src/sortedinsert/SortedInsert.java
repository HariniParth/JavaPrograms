/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedinsert;

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

public class SortedInsert {

    /**
     * @param args the command line arguments
     */
    
    Node head;
    
    void sortedInsert(Node new_node){
        Node current;
        if(head == null || head.data > new_node.data){
            new_node.next = head;
            head = new_node;
        } else {
            current = head;
            while(current.next != null && current.next.data < new_node.data){
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
    }
    
    Node createNode(int d){
        Node node = new Node(d);
        return node;
    }
    
    void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println("Node "+temp.data);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        
        SortedInsert list = new SortedInsert();
        Node node;
        node = list.createNode(5);
        list.sortedInsert(node);
        node = list.createNode(3);
        list.sortedInsert(node);
        node = list.createNode(4);
        list.sortedInsert(node);
        list.printList();
    }
    
}
