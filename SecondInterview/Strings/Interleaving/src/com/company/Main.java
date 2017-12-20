package com.company;

public class Main {

    int[][] dp;

    public boolean interleaving(String s1, String s2, String s3){

        if(s1.length() + s2.length() != s3.length())
            return false;

        if(s3.length() == 0)
            return true;

        dp = new int[s1.length()][s2.length()];

        return isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length());
    }

    public boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3){

        if(i1 >= s1.length() || i2 >= s2.length())
            return s3.substring(i3).equals(i1 >= s1.length()? s2.substring(i2):s1.substring(i1));

        if(dp[i1][i2] > 0)
            return false;

        char c1 = s1.charAt(i1), c2 = s2.charAt(i2), c3 = s3.charAt(i3++);

        if(c1 == c3 && isInterleave(s1, i1+1, s2, i2, s3, i3))
            return true;

        if(c2 == c3 && isInterleave(s1, i1, s2, i2+1, s3, i3))
            return true;

        dp[i1][i2]++;
        return false;
    }
}
