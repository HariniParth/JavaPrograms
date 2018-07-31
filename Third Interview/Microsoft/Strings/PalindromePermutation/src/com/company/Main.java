package com.company;

// https://leetcode.com/articles/palindrome-permutation/

public class Main {

    public boolean palindromePermutation(String s){

        int[] map = new int[128];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)]++;
        }
        int count = 0;
        for(int key=0; key<map.length && count <= 1; key++){
            count += map[key] % 2;
        }
        return (count <= 1);
    }
}
