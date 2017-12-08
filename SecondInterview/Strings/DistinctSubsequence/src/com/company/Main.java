package com.company;

import java.util.*;

public class Main {

    static final int max_char = 256;

    public int subsequence(String s){

        int[] index = new int[max_char];
        Arrays.fill(index, -1);

        int n = s.length();
        int[] distinct = new int[n+1];
        distinct[0] = 1;

        for(int i=1;i<=n;i++){

            distinct[i] = distinct[i-1] * 2;

            if(index[s.charAt(i-1)] != -1)
                distinct[i] = distinct[i] - index[s.charAt(i-1)];

            index[s.charAt(i-1)] = i-1;
        }

        return distinct[n];
    }
}
