package com.company;

// https://leetcode.com/articles/binary-subarrays-with-sum/

// complexity: O(n), Prefix Sums

import java.util.*;

public class Main {

    public int subArraysWithSum(int[] A, int sum){

        int N = A.length;
        int[] P = new int[N+1];
        for(int i=0;i<N;i++){
            P[i+1] = P[i] + A[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int n : P){
            ans += map.getOrDefault(n, 0);
            map.put(n+sum, map.getOrDefault(n+sum, 0)+1);
        }

        return ans;
    }
}