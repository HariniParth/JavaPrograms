package com.company;

// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

public class Main {

    private int maxSubarray(int[] arr){

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int maxHere = 0;

        for(int i=0;i<n;i++){
            maxHere = maxHere + arr[i];
            if(max < maxHere)
                max = maxHere;
            if(maxHere < 0)
                maxHere = 0;
        }
        return max;
    }
}
