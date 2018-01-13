package com.company;

// https://www.geeksforgeeks.org/time-complexities-of-all-sorting-algorithms/

public class Main {

    public void sort(int[] arr){

        int n = arr.length;
        for(int i=0;i<n;i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
