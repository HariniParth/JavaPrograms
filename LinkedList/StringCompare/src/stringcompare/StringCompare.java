/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcompare;

/**
 *
 * @author harini-geek
 */
class Node{
    
    char ch;
    Node next;
    
    Node(char c){
        ch = c;
        next = null;
    }
}

public class StringCompare {

    /**
     * @param args the command line arguments
     */
    
    Node a, b;
    
    int stringCompare(Node node1, Node node2){
        
        if(node1 == null && node2 == null)
            return 1;
        
        while(node1 != null && node2 != null && node1.ch == node2.ch){
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if(node1 != null && node2 != null)
            return (node1.ch > node2.ch ? 1:-1);
        
        if(node1 != null && node2 == null)
            return 1;
        
        if(node1 == null && node2 != null)
            return -1;
        
        return 0;
    }
    
    public static void main(String[] args) {
        
        StringCompare list = new StringCompare();
        list.a = new Node('O');
        list.a.next = new Node('U');
        list.b = new Node('O');
        list.b.next = new Node('M');
        
        int res = list.stringCompare(list.a, list.b);
        System.out.println("Result "+res);
    }
    
}
