package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/shuffle-a-given-array/

public class Main {

    public void shuffleArray(int[] arr){
        Random r = new Random();
        int n = arr.length;

        for(int i=n-1;i>0;i--){
            int j = r.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(arr);
    }
}
