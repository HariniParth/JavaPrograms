package com.company;

// https://www.geeksforgeeks.org/number-subarrays-product-less-k/

public class Main {

    private int subArraysProduct(int[] arr, int k){

        int count = 0, product;
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i] < k)
                count++;

            product = arr[i];
            for(int j=i+1;j<n;j++){
                product *= arr[j];
                if(product < k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
