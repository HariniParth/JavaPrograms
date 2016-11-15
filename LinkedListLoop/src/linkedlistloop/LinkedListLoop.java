/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistloop;


/**
 *
 * @author harini-geek
 */
public class LinkedListLoop {

    /**
     * @param args the command line arguments
     */

    private Node head;
    
    private static class Node{
        private final int value;
        private Node next;
        
        Node(int value){
            this.value = value;
        }
    }
    
    private void addToList(Node node){
        if(head == null){
            head = node;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    
    private void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
    
    private boolean loopPresent(){
        Node fastPtr = head;
        Node slowPtr = head;
        if(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListLoop loop = new LinkedListLoop();
        loop.addToList(new Node(1));
        loop.addToList(new Node(2));
        loop.printList();
        System.out.println("Loop present "+loop.loopPresent());
    }
    
}
