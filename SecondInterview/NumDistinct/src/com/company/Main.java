package com.company;

import java.util.*;

public class Main {

    public int numDistinct(String s1, String s2){

        int m = s1.length();
        int n = s2.length();

        int[][] count = new int[m][n];

        for(int i=0;i<=m;i++){
            Arrays.fill(count[i], 0);
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    if(j == 1)
                        count[i][j] = 1 + count[i-1][j];
                    else
                        count[i][j] = count[i-1][j] + count[i][j-1];
                } else {
                    count[i][j] = count[i-1][j];
                }
            }
        }

        return count[m][m];
    }
}
