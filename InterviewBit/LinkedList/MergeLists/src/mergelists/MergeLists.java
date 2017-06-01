/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergelists;

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

public class MergeLists {

    public ListNode mergeLists(ListNode A, ListNode B){
        if(A == null)
            return B;
        
        if(B == null)
            return A;
        
        ListNode node = new ListNode(0);
        ListNode head = node;
        
        while(A != null && B != null){
            if(A.val <= B.val){
                node.next = A;
                A = A.next;
                node = node.next;
            } else {
                node.next = B;
                B = B.next;
                node = node.next;
            }
        }
        
        if(A == null)
            node.next = B;
        if(B == null)
            node.next = A;
        
        head = head.next;
        
        return head;
    }
    
}
