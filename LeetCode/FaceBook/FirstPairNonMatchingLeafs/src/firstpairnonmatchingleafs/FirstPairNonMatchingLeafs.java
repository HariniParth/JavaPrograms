/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpairnonmatchingleafs;

import java.util.*;

/**
 *
 * @author harini-geek
 * http://shirleyisnotageek.blogspot.com/2016/11/first-pair-non-matching-leaves.html
 */

class TreeNode{
    int val;
    TreeNode left, right;
    
    TreeNode(int d){
        val = d;
        left = right = null;
    }
}

public class FirstPairNonMatchingLeafs {

    public int[] firstPairNonMatchingLeafs(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null)
            return new int[]{-1, -1};
        
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        storeLeaves(node1, tree1);
        storeLeaves(node2, tree2);
        
        TreeNode leaf1 = getLeaf(tree1);
        TreeNode leaf2 = getLeaf(tree2);
        
        while(leaf1 != null && leaf2 != null){
            if(leaf1.val != leaf2.val)
                return new int[]{leaf1.val, leaf2.val};
            leaf1 = getLeaf(tree1);
            leaf2 = getLeaf(tree2);
        }
        return new int[]{-1, -1};
    }
    
    private void storeLeaves(TreeNode node, Stack<TreeNode> stack){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    private TreeNode getLeaf(Stack<TreeNode> stack){
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.left == null && curr.right == null)
                return curr;
            else if(curr.right != null)
                storeLeaves(curr.right, stack);
        }
        return null;
    }
}
