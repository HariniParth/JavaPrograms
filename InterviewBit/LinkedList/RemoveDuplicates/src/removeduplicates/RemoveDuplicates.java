/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicates;

/**
 *
 * @author harini-geek
 */
class ListNode{
    int val;
    ListNode next;
    
    ListNode(int a){
        val = a;
        next = null;
    }
}

public class RemoveDuplicates {

    public ListNode removeDuplicates(ListNode A){
        
        ListNode prevNode;
        ListNode nextNode;
        int val;
        
        prevNode = A;
        nextNode = A.next;
        val = A.val;
        
        while(nextNode != null){
            if(val == nextNode.val){
                prevNode.next = nextNode.next;
            } else {
                prevNode = nextNode;
                val = nextNode.val;
            }
            nextNode = nextNode.next;
        }
        
        return A;
    }
    
}
