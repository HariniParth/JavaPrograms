/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthtolastnode;

/**
 *
 * @author harini-geek
 */

class ListNode{
    int val;
    ListNode next;
    
    ListNode(int d){
        val = d;
        next = null;
    }
}

public class KthToLastNode {

    ListNode KthToLastNode(ListNode node, int k) throws IllegalArgumentException {
        
        if(k < 1)
            throw new IllegalArgumentException("k cannot be less than 1! "+k);
        
        ListNode leftNode = node;
        ListNode rightNode = node;
        
        for(int i=0;i<k-1;i++){
            if(rightNode.next == null)
                throw new IllegalArgumentException("k cannot be larger than the list! "+k);
            
            rightNode = rightNode.next;
        }
        
        while(rightNode.next != null){
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        
        return leftNode;
    }
    
}
