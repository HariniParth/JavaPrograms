package com.company;

// https://www.programcreek.com/2012/12/leetcode-solution-word-break/

import java.util.*;

public class Main {

    public boolean wordBreak(String s, Set<String> dictionary){

        int[] pos = new int[s.length()+1];
        Arrays.fill(pos, -1);
        pos[0] = 0;

        for(int i=0;i<s.length();i++){
            if(pos[i] != -1){
                for(int j=i+1;j<=s.length();j++){
                    String sub = s.substring(i, j);
                    if(dictionary.contains(sub))
                        pos[j] = i;
                }
            }
        }
        return pos[s.length()] != -1;
    }
}
