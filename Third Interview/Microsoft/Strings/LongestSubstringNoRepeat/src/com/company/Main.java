package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/

public class Main {

    private String longestSubstringNonRepeating(String s){

        int n = s.length();
        int start = 0, maxLen = 0, st = 0, len = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        for(int i=0;i<n;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            } else {
                if(map.get(s.charAt(i)) >= st){
                    len = i - st;
                    if(len > maxLen){
                        maxLen = len;
                        start = st;
                    }
                    st = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i), i);
            }
            if(maxLen < i - st){
                maxLen = i - st;
                start = st;
            }
        }

        return s.substring(start, maxLen);
    }
}