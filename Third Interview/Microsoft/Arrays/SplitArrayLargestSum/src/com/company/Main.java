package com.company;

public class Main {

    private int splitArrayLargestSum(int[] arr, int cuts){

        int n = arr.length;
        long l = 0, r = 0;
        for(int i=0;i<n;i++){
            r += arr[i];
            if(l < arr[i]){
                l = arr[i];
            }
        }

        long result = 0;
        while(l <= r){
            long mid = (l + r) >> 1;
            long sum = 0;
            int count = 1;
            for(int i=0;i<n;i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }
            if(count < cuts){
                result = Math.max(result, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int) result;
    }
}