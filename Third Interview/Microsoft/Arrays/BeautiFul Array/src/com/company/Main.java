package com.company;

/* https://leetcode.com/articles/beautiful-array/

    Complexity: O(nlogn)

    For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)

 */

import java.util.*;

public class Main {

    Map<Integer, int[]> result;

    public int[] beautifulArray(int N){

        result = new HashMap<>();
        return beautifulArrayUtil(N);
    }

    private int[] beautifulArrayUtil(int N){

        if(result.containsKey(N))
            return result.get(N);

        int[] ans = new int[N];
        if(N == 1)
            ans[0] = 1;
        else {
            int t = 0;
            for(int o : beautifulArrayUtil((N+1)/2))
                ans[t++] = 2 * o - 1;
            for(int e :beautifulArrayUtil(N/2))
                ans[t++] = 2 * e;
        }
        result.put(N, ans);
        return ans;
    }
}