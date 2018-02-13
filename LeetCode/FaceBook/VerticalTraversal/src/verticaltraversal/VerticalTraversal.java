/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verticaltraversal;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
 */

class TreeNode{
    int val;
    TreeNode left, right;
    
    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class VerticalTraversal {

    ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode node){
        
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
                queue.add(n.left);
                level.offer(l-1);
            }
            
            if(n.right != null){
                queue.add(n.right);
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
