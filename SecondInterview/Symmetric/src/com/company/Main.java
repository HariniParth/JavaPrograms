package com.company;

class TreeNode{
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

    public int solution(TreeNode node){

        return isMirror(node, node) ? 1:0;
    }

    public boolean isMirror(TreeNode a, TreeNode b){

        if(a == null && b == null)
            return true;

        if(a != null && b != null && a.val == b.val)
            return isMirror(a.left, b.right) & isMirror(a.right, b.left);

        return false;
    }

}
