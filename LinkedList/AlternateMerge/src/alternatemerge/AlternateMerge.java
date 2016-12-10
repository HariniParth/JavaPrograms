/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alternatemerge;

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

public class AlternateMerge {

    /**
     * @param args the command line arguments
     */
    Node head;
    
    void addNode(int d){
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }
    
    void alternateMerge(AlternateMerge q){
        Node p_curr = head, q_curr = q.head;
        Node p_next, q_next;
        
        while(p_curr != null && q_curr != null){
            p_next = p_curr.next;
            q_next = q_curr.next;
            
            p_curr.next = q_curr;
            q_curr.next = p_next;
            
            q_curr = q_next;
            p_curr = p_next;
        }     
        q.head = q_curr;
    }
    
    void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println("Node "+temp.data);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        AlternateMerge list1 = new AlternateMerge();
        AlternateMerge list2 = new AlternateMerge();
        
        list1.addNode(3);
        list1.addNode(2);
        list2.addNode(5);
        list2.addNode(4);
        
        list1.alternateMerge(list2);
        list1.printList();
    }
    
}
