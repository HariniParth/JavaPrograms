package com.company;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int d){
        val = d;
        left = null;
        right = null;
    }
}

public class Main {

    TreeNode node;
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    public int LCA(int n1, int n2){
        path1.clear();
        path2.clear();
        return LCAUtil(node, n1, n2);
    }

    public int LCAUtil(TreeNode node, int n1, int n2){
        if(!findPath(node, n1, path1) && !findPath(node, n2, path2)){
            System.out.println((path1.size()>0)? "n1 present":"n1 not present");
            System.out.println((path2.size()>0)? "n2 present":"n2 not present");
            return -1;
        }

        int i;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    public boolean findPath(TreeNode node, int n, List<Integer> path){
        if(node == null)
            return true;

        path.add(node.val);

        if(node.left != null && findPath(node.left, n, path))
            return true;

        if(node.right != null && findPath(node.right, n, path))
            return true;

        path.remove(path.size()-1);

        return false;
    }
}
