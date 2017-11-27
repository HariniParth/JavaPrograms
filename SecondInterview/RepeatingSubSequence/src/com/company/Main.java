package com.company;

import java.util.*;

public class Main {

    public int repeatSeq(String s){

        int n = s.length();
        int[][] count = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(count, 0);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == s.charAt(j-1) && i != j)
                    count[i][j] = count[i-1][j-1] + 1;
                else
                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
            }
        }

        return count[n][n] >= 2 ? 1 : 0;
    }
}
