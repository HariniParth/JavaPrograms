package com.company;

import java.util.*;

public class Main {

    public int countSubStringsKDistinct(String s, int k){

        int res = 0;
        int n = s.length();
        int[] count = new int[n];

        for(int i=0;i<n;i++){
            Arrays.fill(count, 0);
        }

        for(int i=0;i<n;i++){
            int dist_count = 0;
            for(int j=i;j<n;j++){
                if(count[s.charAt(j) - 'a'] == 0)
                    dist_count++;

                count[s.charAt(j) - 'a']++;

                if(dist_count == k)
                    res++;
            }
        }

        return res;
    }
}
