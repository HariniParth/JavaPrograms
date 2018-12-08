package com.company;

import java.util.*;

public class Main {

    private int KthNonRepeating(String s, int k){

        int n = s.length();
        int[] count = new int[n];
        int[] index = new int[n];

        for(int i=0;i<n;i++){
            Arrays.fill(count, 0);
            Arrays.fill(index, n);
        }

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            ++count[c];
            if(count[c] == 1)
                index[c] = i;
            else
                index[c] = n;
        }

        Arrays.sort(index);

        return (index[k-1] != n)? index[k-1] : -1;
    }
}