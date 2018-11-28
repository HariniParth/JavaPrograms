package com.company;

// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/

import java.util.*;

public class Main {

    private List<Integer> firstLastOccurrence(int[] arr, int x){

        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int first = -1, last = -1;
        for(int i=0;i<n;i++){
            if(arr[i] != x)
                continue;
            if(first == -1)
                first = i;

            last = i;
        }
        result.add(first);
        result.add(last);
        return result;
    }
}
