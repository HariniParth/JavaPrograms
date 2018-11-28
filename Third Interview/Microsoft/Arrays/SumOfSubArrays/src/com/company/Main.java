package com.company;

// https://algorithms.tutorialhorizon.com/sum-of-all-sub-arrays-in-on-time/

public class Main {

    private int sumOfSubArrays(int[] arr){

        int n = arr.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += arr[i] * (n-i) * (i+1);
        }
        return total;
    }
}
