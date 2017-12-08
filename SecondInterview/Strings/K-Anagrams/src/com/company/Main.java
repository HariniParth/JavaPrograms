package com.company;

import java.util.*;

public class Main {

    public boolean KAnagrams(String s1, String s2, int k){

        int n = s1.length();
        if(s2.length() != n)
            return false;

        int[] count1 = new int[n];
        int[] count2 = new int[n];
        int count = 0;

        for(int i=0;i<n;i++){
            Arrays.fill(count1, 0);
            Arrays.fill(count2, 0);
        }

        for(int i=0;i<n;i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for(int i=0;i<n;i++){
            if(count1[i] > count2[i])
                count = count + Math.abs(count1[i] - count2[i]);
        }

        return (count <= k);
    }
}
