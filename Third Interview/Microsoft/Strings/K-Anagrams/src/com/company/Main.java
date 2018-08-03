package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/

public class Main {

    public boolean KAnagrams(String str1, String str2, int k){

        int n = str1.length();
        if(str2.length() != n)
            return false;

        int[] count1 = new int[n];
        int[] count2 = new int[n];

        for(int i=0;i<n;i++){
            Arrays.fill(count1, 0);
            Arrays.fill(count2, 0);
        }

        for(int i=0;i<n;i++){
            count1[str1.charAt(i) - 'a']++;
            count2[str2.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(count1[i] > count2[i])
                count += Math.abs(count1[i] - count2[i]);
        }

        return (count <= k);
    }
}
