/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narytreessameleaf;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://discuss.leetcode.com/topic/59025/given-two-n-ary-trees-check-if-they-have-the-same-leaf-nodes-from-left-to-right/2
 */

class TreeNode{
    char data;
    ArrayList<TreeNode> children;
    
    TreeNode(char c){
        data = c;
        children = new ArrayList<>();
    }
}

public class NaryTreesSameLeaf {

    public boolean hasSameLeaf(TreeNode node1, TreeNode node2){
        StringBuilder sb1 = getLeafs(node1);
        StringBuilder sb2 = getLeafs(node2);
        return sb1.equals(sb2);
    }
    
    public StringBuilder getLeafs(TreeNode node){
        if(node == null)
            return null;
        
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode> list = node.children;
        if(list.size() > 0){
            for(int i=0;i<list.size();i++){
                sb.append(getLeafs(list.get(i)));
            }
        } else 
            sb.append(node.data);
        
        return sb;
    }
}

// Complexity: Time O(V), Space O(h)