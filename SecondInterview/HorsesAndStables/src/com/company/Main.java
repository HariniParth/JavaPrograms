package com.company;

import java.util.*;

public class Main {

    int[][] count;

    public int solution(String s, int k){

        int n = s.length();
        count = new int[n][k];
        for(int i=0;i<n;i++){
            Arrays.fill(count[i], -1);
        }
        int result = recurse(0, 0, s, k);

        return (result == Integer.MAX_VALUE)? 0:1;
    }

    public int recurse(int start, int stable, String s, int k){

        int n = s.length();
        if(start == n){
            if(stable == k)
                return 0;
            else
                return Integer.MAX_VALUE;
        }

        if(stable == k)
            return Integer.MAX_VALUE;

        if(count[start][stable] != -1)
            return count[start][stable];

        int result = Integer.MAX_VALUE;
        int W = 0;
        int B = 0;

        for(int i=start;i<n;i++){
            if(s.charAt(i) == 'W')
                W++;
            else if(s.charAt(i) == 'B')
                B++;

            if(W * B > result)
                break;

            int temp = recurse(i+1, stable+1, s, k);
            if(temp != Integer.MAX_VALUE)
                result = Math.min(result, W * B + temp);
        }

        return (count[start][stable] = result);
    }
}
