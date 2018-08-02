package com.company;

import java.util.*;

// https://www.careercup.com/question?id=12174685

public class Main {

    public String removeDuplicates(String s){

        if(s == null || s.length() == 0)
            return null;

        char[] chars = s.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for(char c : chars){
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : set){
            sb.append(c);
        }

        return sb.toString();
    }
}
