package com.company;

import java.util.*;

public class Main {

    public int palinSequences(String s){

        int n = s.length();
        int[][] count = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(count[i], 1);
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n;i++){
                int k = l - i + 1;
                if(k < n){
                    if(s.charAt(i) == s.charAt(k))
                        count[i][k] = count[i+1][k] + count[i][k-1] + 1;
                    else
                        count[i][k] = count[i][k-1] + count[i+1][k] - count[i+1][k-1];
                }
            }
        }

        return count[0][n-1];
    }
}
