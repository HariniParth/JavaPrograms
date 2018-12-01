package com.company;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(int d){
        val = d;
        next = null;
    }
}

public class Main {

    private ListNode head;

    private TreeNode convertListToTree(TreeNode node){

        Queue<TreeNode> queue = new LinkedList<>();
        node = new TreeNode(head.val);
        queue.add(node);
        head = head.next;

        while(head != null){
            TreeNode parent = queue.peek();
            TreeNode left, right = null;
            left = new TreeNode(head.val);
            queue.add(left);
            head = head.next;

            if(head != null){
                right = new TreeNode(head.val);
                queue.add(right);
                head = head.next;
            }
            parent.left = left;
            parent.right = right;
        }
        return node;
    }
}