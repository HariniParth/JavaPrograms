package com.company;

import java.util.*;

public class Main {

    public int subStringKUnique(String s, int k){

        if(s == null || s.length() == 0 || k == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0, j=0, ans=Integer.MIN_VALUE;

        for(i=0;i<n;i++){
            while(j < n){
                char ch_j = s.charAt(j);
                if(!map.containsKey(ch_j)){
                    if(map.size() == k)
                        break;
                    else
                        map.put(ch_j, 1);
                } else {
                    map.put(ch_j, map.get(ch_j)+1);
                }
                j++;
            }

            ans = Math.max(ans, j-i);
            char ch_i = s.charAt(i);
            if(map.containsKey(ch_i)){
                if(map.get(ch_i) - 1 == 0)
                    map.remove(ch_i);
                else
                    map.put(ch_i, map.get(ch_i) - 1);
            }
        }

        return ans;
    }
}
