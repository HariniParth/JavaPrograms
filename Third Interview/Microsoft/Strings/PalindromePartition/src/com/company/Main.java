package com.company;

// https://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/

public class Main {

    public int palindromePartition(String s){

        if(s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[][] count = new int[n][n];
        boolean[][] isPalin = new boolean[n][n];

        for(int i=0;i<n;i++){
            count[i][i] = 0;
            isPalin[i][i] = true;
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j = i+l-1;

                if(l == 2)
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j) && isPalin[i+1][j-1]);

                if(isPalin[i][j])
                    count[i][j] = 0;
                else {
                    count[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        count[i][j] = Math.min(count[i][j], count[i][k] + count[k+1][j]);
                    }
                }
            }
        }
        return count[0][n-1];
    }
}