package com.company;

import java.util.*;

// https://www.interviewcake.com/question/java/product-of-other-numbers

// Time Complexity: O(n) and Space Complexity: O(n)

public class Main {

    public int[] productOfOthers(int[] arr){

        if(arr.length < 2)
            return arr;

        int n = arr.length;
        int[] resultProduct = new int[n];
        int product = 1;

        for(int i=0;i<n;i++){
            resultProduct[i] = product;
            product *= arr[i];
        }

        product = 1;
        for(int i=n-1;i>=0;i--){
            resultProduct[i] *= product;
            product *= arr[i];
        }

        return resultProduct;
    }
}