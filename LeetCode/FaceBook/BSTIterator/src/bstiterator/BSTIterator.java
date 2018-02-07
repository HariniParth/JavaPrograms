/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstiterator;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
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

public class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    
    public int next(){
        TreeNode node = stack.pop();
        int result = node.val;
        while(node.right != null){
            node = node.right;
            if(node != null){
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }
}
