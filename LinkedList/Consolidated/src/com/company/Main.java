package com.company;

import java.util.*;

class ListNode{
    int val;
    ListNode next;

    ListNode(int d){
        val = d;
        next = null;
    }
}

public class Main {

    ListNode head;

    public ListNode addNode(int d){
        ListNode node = new ListNode(d);
        node.next = head;
        head = node;
        return node;
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null, curr = node, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public ListNode rearrange(ListNode node){
        ListNode fastPtr = node;
        ListNode slowPtr = node;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        ListNode node1 = node;
        ListNode node2 = slowPtr.next;
        slowPtr.next = null;

        node = new ListNode(0);
        ListNode curr = node;
        while(node1 != null || node2 != null){
            if(node1 != null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if(node2 != null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        return node;
    }

    public ListNode cycle(ListNode node){
        HashSet<ListNode> set = new HashSet<>();
        while(node != null){
            if(set.contains(node))
                return node;
            else
                set.add(node);

            node = node.next;
        }
        return null;
    }

    public ListNode intersection(ListNode node1, ListNode node2){
        int l1 = 0;
        int l2 = 0;
        ListNode n1 = node1;
        while(n1 != null){
            l1++;
            n1 = n1.next;
        }
        ListNode n2 = node2;
        while(n2 != null){
            l2++;
            n2 = n2.next;
        }
        if(l1 < l2){
            ListNode temp = node1;
            node1 = node2;
            node2 = temp;

            int l = l1;
            l1 = l2;
            l2 = l;
        }
        int d = l1 - l2;
        for(int i=0;i<d;i++){
            node1 = node1.next;
        }
        while(node1 != null){
            if(node1 == node2)
                return node1;

            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    public ListNode mergeList(ListNode node1, ListNode node2){
        ListNode result = null;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        if(node1.val <= node2.val){
            result = node1;
            result.next = mergeList(node1.next, node2);
        } else {
            result = node2;
            result.next = mergeList(node1, node2.next);
        }
        return result;
    }

    public ListNode addTwoLists(ListNode node1, ListNode node2){
        ListNode result = null;
        ListNode temp = null;
        ListNode prev = null;
        int carry = 0;
        int sum;

        while(node1 != null || node2 != null){
            sum = carry + (node1 != null? node1.val:0) + (node2 != null? node2.val:0);
            carry = (sum >= 10)? 1:0;
            if(sum > 10)
                sum %= 10;

            temp = new ListNode(sum);
            if(result == null)
                result = temp;
            else
                prev.next = temp;
            prev = temp;
            if(node1 != null)
                node1 = node1.next;
            if(node2 != null)
                node2 = node2.next;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);

        return result;
    }

    public void removeNode(ListNode node, ListNode n){
        if(node == n){
            if(node.next == null){
                System.out.print("Cannot remove!");
            } else {
                node.val = node.next.val;
                node.next = node.next.next;
                System.gc();
            }
        } else {
            ListNode curr = node;
            while(curr.next != null && curr.next != n)
                curr = curr.next;
            if(curr.next == null)
                System.out.print("Node not found!");
            if(curr.next == n){
                curr.next = curr.next.next;
                System.gc();
            }
        }
    }

    public void sortedInsert(ListNode node){
        if(head == null || head.val >= node.val){
            node.next = head;
            head = node;
        } else {
            ListNode curr = head;
            while(curr.next != null && curr.next.val < node.val)
                curr = curr.next;

            node.next = curr.next;
            curr.next = node;
        }
    }

    public ListNode removeNth(ListNode node, int n){
        int l = 0;
        ListNode curr = node;
        while(curr != null){
            l++;
            curr = curr.next;
        }

        if(n >= l)
            return node.next;
        else {
            int d = l - n;
            curr = node;
            for(int i=0;i<d;i++)
                curr = curr.next;
            ListNode rm = curr.next;
            if(rm.next == null)
                curr.next = null;
            else
                curr.next = rm.next;
        }
        return node;
    }

    public ListNode swapPairs(ListNode node){
        if(node == null || node.next == null)
            return node;

        ListNode ptr = node;
        ListNode sptr = ptr.next;
        ListNode prev;
        ListNode next = sptr.next;

        node = sptr;
        sptr.next = ptr;
        ptr.next = next;
        prev = ptr;
        ptr = next;
        while(ptr != null){
            sptr = ptr.next;
            if(sptr == null){
                prev.next = ptr;
                break;
            } else {
                next = sptr.next;
                prev.next = sptr;
                sptr.next = ptr;
                ptr.next = next;
                prev = ptr;
            }
            ptr = next;
        }
        return node;
    }

    public ListNode partition(ListNode node, int k){
        ListNode left = node;
        ListNode leftHead = node;
        ListNode right = node;
        ListNode rightHead = node;

        ListNode curr = node.next;
        if(node.val >= k){
            while(curr != null && curr.val >= k){
                right = curr;
                curr = curr.next;
            }
            if(curr == null)
                return node;

            leftHead = curr;
            left = curr;
        } else {
            while(curr != null && curr.val < k){
                left = curr;
                curr = curr.next;
            }
            if(curr == null)
                return node;

            rightHead = curr;
            right = curr;
        }
        curr = curr.next;
        while(curr != null){
            if(curr.val >= k){
                right.next = curr;
                right = right.next;
            } else {
                left.next = curr;
                left = left.next;
            }
            curr = curr.next;
        }
        right = null;
        left.next = rightHead;
        return leftHead;
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if(node1 != null)
            curr.next = node1;
        else
            curr.next = node2;

        return res;
    }

    public void swap(ListNode node1, ListNode node2){
        node1.val = node1.val + node2.val;
        node2.val = node1.val - node2.val;
        node1.val = node1.val - node2.val;
    }

    public ListNode insertion(ListNode node){
        ListNode prev = node;
        ListNode curr;
        while(prev != null){
            curr = prev.next;
            while(curr != null){
                if(prev.val > curr.val)
                    swap(prev, curr);

                curr = curr.next;
            }
            prev = prev.next;
        }
        return node;
    }

    public ListNode mergeKLists(List<ListNode> list){
        if(list == null || list.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
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

    public void altremove(){
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null && next != null){
            curr.next = next.next;
            next = null;

            curr = curr.next;
            if(curr != null)
                next = curr.next;
        }
    }

    public ListNode groupReverse(ListNode node, int k){

        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            node.next = groupReverse(next, k);

        return prev;
    }

    public ListNode reverseAlt(ListNode node, int k) {

        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(node != null)
            node.next = curr;

        count = 0;
        while(curr != null && count < k-1){
            curr = curr.next;
            count++;
        }

        if(curr != null){
            curr.next = reverseAlt(curr.next, k);
        }

        return prev;
    }

    public void removeNextHigher(){

        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.next.val > curr.val){
                curr.next = curr.next.next;
                curr.next = null;
            }
            curr = curr.next;
        }
    }

    public void segregate(){

        ListNode curr = head;
        ListNode prev = null;
        ListNode end = head;

        while(end.next != null)
            end = end.next;

        ListNode new_end = end;

        while(curr != null && curr.val % 2 != 0){
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(curr.val % 2 == 0){
            head = curr;

            while(curr != null){
                if(curr.val % 2 == 0){
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else
            prev = curr;

        if(end != new_end && end.val % 2 != 0){
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    public void rotateList(int k){
        if(k == 0)
            return;

        ListNode curr = head;
        int count = 1;

        while(curr != null && count < k)
            curr = curr.next;

        ListNode KthNode = curr;

        while(curr.next != null)
            curr = curr.next;

        curr.next = head;
        head = KthNode.next;
        KthNode.next = null;
    }

    public void removeDuplicates(){
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
                curr.next = null;
            }
            curr = curr.next;
        }
    }

    public void removeUnsortedDup(){
        ListNode ptr1 = head;
        while(ptr1 != null){
            ListNode ptr2 = ptr1;
            while(ptr2 != null){
                if(ptr1.val == ptr2.next.val){
                    ptr2.next = ptr2.next.next;
                    System.gc();
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }
}