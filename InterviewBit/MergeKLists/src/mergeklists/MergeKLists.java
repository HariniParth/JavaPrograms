/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeklists;

import java.util.*;


/**
 *
 * @author harini-geek
*/

class ListNode{
    int value;
    ListNode next;
    
    ListNode(int n){
        value = n;
        next = null;
    }
}

public class MergeKLists{
    
    public ListNode merge(ArrayList<ListNode> AL){
        
        TreeMap<Integer, ArrayList<ListNode>> map = new TreeMap<>();
        ArrayList<ListNode> list;
        ListNode node;
        int val;
        
        for(ListNode n : AL){
            node = n;
            if(node != null){
                val = node.value;
                if(map.containsKey(val)){
                    list = map.get(val);
                    list.add(node);
                } else {
                    list = new ArrayList<>();
                    list.add(node);
                    map.put(val, list);
                }
                node = node.next;
            }
        }
        
        ListNode head = null;
        node = null;
        
        for(Map.Entry<Integer, ArrayList<ListNode>> entry : map.entrySet()){
            list = entry.getValue();
            for(ListNode n : list){
                if(head == null)
                    head = n;
                if(node != null)
                    node.next = n;
                node = n;
            }
        }
        return head;
    }
}