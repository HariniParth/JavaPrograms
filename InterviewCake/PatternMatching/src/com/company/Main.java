package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/find-all-strings-that-match-specific-pattern-in-a-dictionary/

public class Main {

    public void patternMatching(List<String> strings, String pattern){
        int len = pattern.length();
        String hash = findPattern(pattern);
        for(String string : strings){
            if(string.length() == len && findPattern(pattern).equals(hash))
                System.out.println(string);
        }
    }

    public String findPattern(String pattern){
        HashMap<Character, Integer> map = new HashMap<>();
        String result = "";
        int count = 0;

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch))
                map.put(ch, count++);

            result += map.get(ch);
        }
        return result;
    }
}
