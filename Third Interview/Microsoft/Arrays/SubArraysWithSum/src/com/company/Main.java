package com.company;

// https://leetcode.com/articles/binary-subarrays-with-sum/
// https://stackoverflow.com/questions/46061941/how-to-find-all-subarrays-with-sum-k-in-on-time-complexity

// complexity: O(n), Prefix Sums

import java.util.*;

public class Main {

    private int subArraysWithSum(int[] arr, int sum){

        int n = arr.length;
        int[] P = new int[n+1];
        for(int i=0;i<n;i++){
            P[i+1] = P[i] + arr[i];
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : P){
            ans += map.getOrDefault(num, 0);
            map.put(num+sum, map.getOrDefault(num+sum, 0)+1);
        }
        return ans;
    }

    private List<int[]> subArrays(int[] arr, int sum){

        List<int[]> result = new ArrayList<>();
        int[] temp;
        int start = 0, end = 0, currSum = 0;

        do {
            if(end == arr.length && currSum < sum)
                break;
            if(currSum < sum)
                currSum += arr[end++];
            else if(currSum > sum)
                currSum -= arr[start++];
            else {
                result.add(temp = new int[end-start]);
                System.arraycopy(arr, start, temp, 0, temp.length);
                currSum += arr[start];
                start++;
            }
        } while(start <= arr.length && end <= arr.length);

        return result;
    }
}