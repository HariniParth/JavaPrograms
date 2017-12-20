package com.company;

import java.util.*;

public class Main {

    public int longestSubstringNonRepeatingChars(String s){

        if(s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i=0, j=0, ans=0;

        for(i=0;i<n;i++){
            while(j < n && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
                j++;
            }
            set.remove(s.charAt(i));
        }

        return ans;
    }
}
