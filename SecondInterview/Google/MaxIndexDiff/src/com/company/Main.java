package com.company;

public class Main {

    public int maxIndexDiff(int[] arr){

        int n = arr.length;
        int maxDiff = -1;

        for(int i=0;i<n;++i){
            for(int j=n-1;j>i;--j){
                if(arr[j] > arr[i] && j-i > maxDiff){
                    maxDiff = j-i;
                }
            }
        }

        return maxDiff;
    }
}
