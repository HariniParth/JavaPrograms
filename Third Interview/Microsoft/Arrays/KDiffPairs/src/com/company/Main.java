package com.company;

// https://www.geeksforgeeks.org/count-pairs-difference-equal-k/

public class Main {

    private int KDiffPairs(int[] arr, int k){

        int result = 0;
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i] - arr[j] == k ||
                        arr[j] - arr[i] == k)
                    result++;
            }
        }
        return result;
    }
}
