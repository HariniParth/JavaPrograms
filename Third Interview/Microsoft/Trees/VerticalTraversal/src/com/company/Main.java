package com.company;

// https://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    public ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode node){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        queue.add(node);
        level.add(0);

        int minLevel = 0;
        int maxLevel = 0;

        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            int l = level.poll();

            minLevel = Math.min(minLevel, l);
            maxLevel = Math.max(maxLevel, l);

            if(map.containsKey(l))
                map.get(l).add(n.val);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n.val);
                map.put(l, list);
            }

            if(n.left != null){
                queue.add(n);
                level.offer(l-1);
            }

            if(n.right != null){
                queue.add(n);
                level.offer(l+1);
            }
        }

        for(int i=minLevel;i<=maxLevel;i++){
            if(map.containsKey(i))
                result.add(map.get(i));
        }

        return result;
    }
}