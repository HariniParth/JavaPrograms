package com.company;

// https://javaconceptoftheday.com/duplicate-characters-in-a-string-in-java/

import java.util.*;

public class Main {

    public void duplicateCharacters(String s){

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }

        Set<Character> set = map.keySet();
        for(Character c : set){
            if(map.get(c) > 1)
                System.out.print(c+" ");
        }
    }
}
