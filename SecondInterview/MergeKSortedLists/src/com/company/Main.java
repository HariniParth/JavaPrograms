package com.company;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int d){
        val = d;
        next = null;
    }
}

public class Main {

    public ListNode mergeKLists(List<ListNode> list){

        if(list == null || list.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
           public int compare(ListNode l1, ListNode l2){
               return l1.val - l2.val;
           }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode node : list){
            if(node != null)
                queue.offer(node);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if(n.next != null)
                queue.offer(n.next);
        }

        return head.next;
    }

}
