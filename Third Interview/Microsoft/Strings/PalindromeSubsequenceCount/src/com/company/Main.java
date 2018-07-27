package com.company;

import java.util.*;

public class Main {

    public int palindromeSubsequenceCount(String s){

        if(s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[][] count = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(count[i], 1);
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n;i++){
                int j = l-i+1;
                if(j < n){
                    if(s.charAt(i) == s.charAt(j))
                        count[i][j] = count[i+1][j] + count[i][j-1] + 1;
                    else
                        count[i][j] = count[i+1][j] + count[i][j-1] - count[i+1][j-1];
                }
            }
        }
        return count[0][n-1];
    }
}
