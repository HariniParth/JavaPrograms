/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 */

class TrieNode{
    
    private final TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    public void set(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}

public class Trie {

    private final TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
                node.set(ch, new TrieNode());
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    // T & S Complexity: O(m) where m is key length.
    
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch))
                node = node.get(ch);
            else
                return null;
        }
        return node;
    }
    
    private boolean startsWith(String word){
        TrieNode node = searchPrefix(word);
        return node != null;
    }
}
