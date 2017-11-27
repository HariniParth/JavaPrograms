package com.company;

import java.util.*;

public class Main {

    public int palin(String s){

        int n = s.length();
        int[][] count = new int[n][n];
        boolean[][] palin = new boolean[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(count[i], 0);
            Arrays.fill(palin[i], true);
        }

        for(int l=2;l<=n;l++){

            for(int i=0;i<n-l+1;i++){
                int j = i + l - 1;

                if(l == 2){
                    palin[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    palin[i][j] = (s.charAt(i) == s.charAt(j)) && palin[i+1][j-1];
                }

                if(palin[i][j])
                    count[i][j] = 0;
                else {
                    count[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        count[i][j] = Math.min(count[i][j], count[i][k] + count[k+1][j] + 1);
                    }
                }
            }
        }

        return count[0][n-1];
    }
}
